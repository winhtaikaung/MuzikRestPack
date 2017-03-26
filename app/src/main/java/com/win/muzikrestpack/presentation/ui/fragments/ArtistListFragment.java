package com.win.muzikrestpack.presentation.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.win.muzikrestpack.R;
import com.win.muzikrestpack.data.network.converter.RESTArtistModelConverter;
import com.win.muzikrestpack.data.repositories.ArtistDataRepository;
import com.win.muzikrestpack.data.repositories.datasource.ArtistDataStoreFactory;
import com.win.muzikrestpack.domain.executor.impl.ThreadExecutor;
import com.win.muzikrestpack.domain.model.Artist;
import com.win.muzikrestpack.presentation.presenters.ArtistListPresenter;
import com.win.muzikrestpack.presentation.presenters.impl.ArtistListPresenterImpl;
import com.win.muzikrestpack.threading.MainThreadImpl;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by win on 3/25/17.
 */

public class ArtistListFragment extends Fragment implements ArtistListPresenter.View{


    private ArtistListPresenter mArtistListPresenter;
    private ArtistDataRepository mArtistDataRepository;
    private ArtistDataStoreFactory mArtistDataStoreFactory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artistlist, container, false);
        ButterKnife.bind(this, view);

        mArtistDataStoreFactory = new ArtistDataStoreFactory();
        mArtistDataRepository = new ArtistDataRepository(mArtistDataStoreFactory, new RESTArtistModelConverter());
        mArtistListPresenter = new ArtistListPresenterImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(),this,mArtistDataRepository);
        mArtistListPresenter.getAllArtistModel("1","3");
        return view;
    }

    @Override
    public void onArtistModelRetrieved(List<Artist> artistList) {
        Log.e("ArtistList",String.valueOf(artistList.size()));
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }
}
