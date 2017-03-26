package com.win.muzikrestpack.presentation.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.win.muzikrestpack.R;
import com.win.muzikrestpack.data.network.converter.RESTSongModelConverter;
import com.win.muzikrestpack.data.repositories.SongDataRepository;
import com.win.muzikrestpack.data.repositories.datasource.SongDataStoreFactory;
import com.win.muzikrestpack.domain.executor.impl.ThreadExecutor;
import com.win.muzikrestpack.domain.model.Song;
import com.win.muzikrestpack.presentation.presenters.SongListPresenter;
import com.win.muzikrestpack.presentation.presenters.impl.SongListPresenterImpl;
import com.win.muzikrestpack.presentation.ui.adapters.SongListAdapter;
import com.win.muzikrestpack.presentation.ui.base.EndlessRecyclerViewAdapter;
import com.win.muzikrestpack.threading.MainThreadImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by win on 3/25/17.
 */

public class SongListFragment extends Fragment implements SongListPresenter.View {
    @BindView(R.id.rvSongList)
    RecyclerView mSongListRecyclerView;

    @BindView(R.id.progressView)
    FrameLayout mProgressView;

    @BindView(R.id.errView)
    FrameLayout mErrorView;

    @BindView(R.id.tvErrorText)
    TextView tvErrorText;

    private List<Song> mSongList;
    private SongListPresenter mSongListPresenter;

    private int mCounter = 1;
    private EndlessRecyclerViewAdapter mEndlessRecyclerViewAdapter;
    private SongListAdapter mSongListAdapter;

    private SongDataStoreFactory songDataStoreFactory;
    private SongDataRepository songDataRepository;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_songlist, container, false);
        ButterKnife.bind(this, view);

        songDataStoreFactory = new SongDataStoreFactory();
        songDataRepository = new SongDataRepository(songDataStoreFactory, new RESTSongModelConverter());
        mSongListPresenter = new SongListPresenterImpl(ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(), this, songDataRepository);

        if(mSongListPresenter.doCheckDataConnection(this.getActivity())) {
            mSongListPresenter.getAllSongsModel("1","3");
            fillRecyclerView();
        }

        return view;
    }


    private void fillRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        mSongListRecyclerView.setLayoutManager(linearLayoutManager);
        mSongListAdapter = new SongListAdapter();
        mSongListAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        mEndlessRecyclerViewAdapter = new EndlessRecyclerViewAdapter(this.getActivity(), mSongListAdapter, new EndlessRecyclerViewAdapter.RequestToLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (mCounter == 1) {
                    mSongListPresenter.getAllSongsModel("1", "3");
                } else {
                    mSongListPresenter.getAllSongsModel(String.valueOf(mCounter), "3");
                }
            }
        });

        mSongListRecyclerView.setAdapter(mEndlessRecyclerViewAdapter);
    }


    @Override
    public void onAllSongModelRetrieved(final List<Song> songList) {
        if (songList.size() > 0) {
            if (mCounter == 1) {
                mSongList = songList;
            } else {

                mSongList.addAll(songList);

            }
            mSongListAdapter.setSongList(mSongList);
            mEndlessRecyclerViewAdapter.onDataReady(true);
            mCounter++;

        } else {
            mEndlessRecyclerViewAdapter.onDataReady(false);
        }
    }

    @Override
    public void showProgress() {
        mProgressView.setVisibility(View.VISIBLE);
        mSongListRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        Log.e("HIDE PROGRESS", "HIDE PROGRESS");
        mProgressView.setVisibility(View.GONE);
        mSongListRecyclerView.setVisibility(View.VISIBLE);

    }

    @Override
    public void showError(String message) {
        mProgressView.setVisibility(View.GONE);
        mSongListRecyclerView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
        tvErrorText.setText(message);
    }

    @Override
    public void hideError(String message) {
        mSongListRecyclerView.setVisibility(View.VISIBLE);
        mErrorView.setVisibility(View.GONE);
        tvErrorText.setText(message);
    }
}
