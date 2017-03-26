package com.win.muzikrestpack.presentation.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.win.muzikrestpack.R;
import com.win.muzikrestpack.data.network.converter.RESTArtistModelConverter;
import com.win.muzikrestpack.data.repositories.ArtistDataRepository;
import com.win.muzikrestpack.data.repositories.datasource.ArtistDataStoreFactory;
import com.win.muzikrestpack.domain.executor.impl.ThreadExecutor;
import com.win.muzikrestpack.domain.model.Artist;
import com.win.muzikrestpack.presentation.presenters.ArtistListPresenter;
import com.win.muzikrestpack.presentation.presenters.impl.ArtistListPresenterImpl;
import com.win.muzikrestpack.presentation.ui.activities.ArtistDetailActivity;
import com.win.muzikrestpack.presentation.ui.adapters.ArtistListAdapter;
import com.win.muzikrestpack.presentation.ui.base.EndlessRecyclerViewAdapter;
import com.win.muzikrestpack.threading.MainThreadImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by win on 3/25/17.
 */

public class ArtistListFragment extends Fragment implements ArtistListPresenter.View, AdapterView.OnItemClickListener {
    @BindView(R.id.rvArtistList)
    RecyclerView mArtistListRecyclerview;

    @BindView(R.id.progressView)
    FrameLayout mProgressView;

    @BindView(R.id.errView)
    FrameLayout mErrorView;

    @BindView(R.id.tvErrorText)
    TextView tvErrorText;

    private List<Artist> mArtistList;
    private ArtistListPresenter mArtistListPresenter;
    private ArtistDataRepository mArtistDataRepository;
    private ArtistDataStoreFactory mArtistDataStoreFactory;

    private int mCounter = 1;
    private EndlessRecyclerViewAdapter mEndlessRecyclerViewAdapter;
    private ArtistListAdapter mArtistListAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artistlist, container, false);
        ButterKnife.bind(this, view);

        mArtistDataStoreFactory = new ArtistDataStoreFactory();
        mArtistDataRepository = new ArtistDataRepository(mArtistDataStoreFactory, new RESTArtistModelConverter());
        mArtistListPresenter = new ArtistListPresenterImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), this, mArtistDataRepository);

        if (mArtistListPresenter.doCheckDataConnection(this.getActivity())) {
            mArtistListPresenter.getAllArtistModel("1", "3");
            fillRecyclerView();
        }
        return view;
    }

    private void fillRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        mArtistListRecyclerview.setLayoutManager(linearLayoutManager);
        mArtistListAdapter = new ArtistListAdapter();
        mArtistListAdapter.setOnItemClickListener(this);
        mEndlessRecyclerViewAdapter = new EndlessRecyclerViewAdapter(this.getActivity(), mArtistListAdapter, new EndlessRecyclerViewAdapter.RequestToLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (mCounter == 1) {
                    mArtistListPresenter.getAllArtistModel("1", "3");
                } else {
                    mArtistListPresenter.getAllArtistModel(String.valueOf(mCounter), "3");
                }
            }
        });

        mArtistListRecyclerview.setAdapter(mEndlessRecyclerViewAdapter);
    }


    @Override
    public void onArtistModelRetrieved(List<Artist> artistList) {
        if (artistList.size() > 0) {
            if (mCounter == 1) {
                this.mArtistList = artistList;
            } else {

                this.mArtistList.addAll(artistList);

            }
            mArtistListAdapter.setmArtistList(this.mArtistList);
            mEndlessRecyclerViewAdapter.onDataReady(true);
            mCounter++;

        } else {
            mEndlessRecyclerViewAdapter.onDataReady(false);
        }
    }

    @Override
    public void showProgress() {
        mProgressView.setVisibility(View.VISIBLE);
        mArtistListRecyclerview.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        mProgressView.setVisibility(View.GONE);
        mArtistListRecyclerview.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String message) {
        mProgressView.setVisibility(View.GONE);
        mArtistListRecyclerview.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
        tvErrorText.setText(message);
    }

    @Override
    public void hideError(String message) {
        mErrorView.setVisibility(View.GONE);
        mArtistListRecyclerview.setVisibility(View.VISIBLE);
        tvErrorText.setText(message);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this.getActivity(), ArtistDetailActivity.class);
        intent.putExtra("ARTIST_ID", mArtistList.get(i).getId());
        startActivity(intent);
    }
}
