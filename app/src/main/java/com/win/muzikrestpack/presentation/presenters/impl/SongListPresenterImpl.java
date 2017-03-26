package com.win.muzikrestpack.presentation.presenters.impl;

import android.content.Context;

import com.win.muzikrestpack.domain.executor.Executor;
import com.win.muzikrestpack.domain.executor.MainThread;
import com.win.muzikrestpack.domain.interactors.GetAllSongModelInteractor;
import com.win.muzikrestpack.domain.interactors.impl.Song.GetAllSongModelnteractorImpl;
import com.win.muzikrestpack.domain.model.SongModel;
import com.win.muzikrestpack.domain.repository.SongRepository;
import com.win.muzikrestpack.presentation.presenters.AbstractPresenter;
import com.win.muzikrestpack.presentation.presenters.SongListPresenter;
import com.win.muzikrestpack.presentation.utils.ConnectionHelper;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by win on 3/26/17.
 */

public class SongListPresenterImpl extends AbstractPresenter implements SongListPresenter, GetAllSongModelInteractor.Callback {

    private SongListPresenter.View mView;
    private SongRepository mSongRepository;

    /**
     * @param executor
     * @param mainThread
     * @param view
     * @param songRepository
     */
    public SongListPresenterImpl(Executor executor, MainThread mainThread, View view, SongRepository songRepository) {
        super(executor, mainThread);
        mView = view;
        mSongRepository = songRepository;

    }

    @Override
    public void getAllSongsModel(String page, String pageSize) {
        GetAllSongModelInteractor songModelInteractor = new GetAllSongModelnteractorImpl(mExecutor,
                mMainThread, mSongRepository, page, pageSize, this);
        songModelInteractor.execute();
    }

    @Override
    public boolean doCheckDataConnection(Context context) {
        if (!ConnectionHelper.isOnline(context)) {
            mView.showError("Cannot connect to server");
            return false;
        } else {
            mView.hideError("");
            return true;
        }
    }

    @Override
    public void onAllSongModelRetrieved(final Observable<SongModel> songModelObservable) {


        songModelObservable.doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mView.showError("Cannot Fetch data");
            }
        }).subscribe(new Consumer<SongModel>() {
            @Override
            public void accept(SongModel songModel) throws Exception {
                mView.onAllSongModelRetrieved(songModel.getSongs());
            }


        });
        mView.hideProgress();
        mView.hideError("");
    }

    @Override
    public void noSongFound() {
        mView.showError("No Song found");
    }
}
