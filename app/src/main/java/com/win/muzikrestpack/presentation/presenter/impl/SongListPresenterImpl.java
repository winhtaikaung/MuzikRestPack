package com.win.muzikrestpack.presentation.presenter.impl;

import com.win.muzikrestpack.domain.executor.Executor;
import com.win.muzikrestpack.domain.executor.MainThread;
import com.win.muzikrestpack.domain.interactors.GetSongModelByArtistIdInteractor;
import com.win.muzikrestpack.domain.model.SongModel;
import com.win.muzikrestpack.domain.repository.SongRepository;
import com.win.muzikrestpack.presentation.presenter.AbstractPresenter;
import com.win.muzikrestpack.presentation.presenter.SongListPresenter;

import io.reactivex.Observable;

/**
 * Created by win on 3/25/17.
 */

public class SongListPresenterImpl extends AbstractPresenter implements SongListPresenter, GetSongModelByArtistIdInteractor.Callback {

    private SongListPresenter.View mView;
    private SongRepository mSongRepository;

    /**
     *
     * @param executor
     * @param view
     * @param mainThread
     * @param repository
     */
    public SongListPresenterImpl(Executor executor,View view, MainThread mainThread,SongRepository repository) {
        super(executor, mainThread);
        mView = view;
        mSongRepository = repository;

    }

    @Override
    public void onSongModelRetrieved(Observable<SongModel> songModelObservable) {

    }


}
