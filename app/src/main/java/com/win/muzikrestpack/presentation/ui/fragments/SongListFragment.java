package com.win.muzikrestpack.presentation.ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.win.muzikrestpack.R;
import com.win.muzikrestpack.domain.model.Links;
import com.win.muzikrestpack.domain.model.Song;
import com.win.muzikrestpack.presentation.ui.adapters.SongListAdapter;
import com.win.muzikrestpack.presentation.ui.base.EndlessRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by win on 3/25/17.
 */

public class SongListFragment extends Fragment  {

    private List<Song> mSongList;



    @BindView(R.id.rvSongList)
    RecyclerView mSongListRecyclerView;

    private int mCounter = 1;
    private EndlessRecyclerViewAdapter mEndlessRecyclerViewAdapter;
    private SongListAdapter mSongListAdapter;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_songlist,container,false);
        ButterKnife.bind(this,view);



        return view;
    }


    private void fillRecyclerView(){
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
                loadSongData();
            }
        });


        mSongListRecyclerView.setAdapter(mEndlessRecyclerViewAdapter);
    }

    private void loadSongData(){
        Handler handler = new Handler();
        //Cannot in synchronous mode
        // http://stackoverflow.com/questions/27070220/recycleview-notifydatasetchanged-illegalstateexception
        final Runnable r = new Runnable() {
            public void run() {
                if(mCounter == 1){
                    mSongList = dummydata();
                }else {

                    mSongList.addAll(dummydata());

                }
                mSongListAdapter.setSongList(mSongList);
                mEndlessRecyclerViewAdapter.onDataReady(true);
                mCounter++;
                Log.e("COUNTER",String.valueOf(mCounter));
            }
        };

        handler.post(r);


    }

    private List<Song> dummydata(){
        Song dummySongfirst = new Song("1", "Mona", "http://ab.com", new Links("1", "1")
        );
        Song dummySongsecond = new Song("1", "Mona", "http://ab.com", new Links("2", "2")
        );
        Song dummySongthird = new Song("1", "Mona", "http://ab.com", new Links("3", "3")
        );
        Song dummySongfouth = new Song("1", "Mona", "http://ab.com", new Links("4", "4")
        );

        List<Song> dummySongList = new ArrayList<>();
        dummySongList.add(dummySongfirst);
        dummySongList.add(dummySongsecond);
        dummySongList.add(dummySongthird);
        dummySongList.add(dummySongfouth);

        return dummySongList;
    }



}
