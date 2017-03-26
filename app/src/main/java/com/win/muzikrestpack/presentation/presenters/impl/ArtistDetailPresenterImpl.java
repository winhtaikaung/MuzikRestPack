package com.win.muzikrestpack.presentation.presenters.impl;

import com.win.muzikrestpack.domain.executor.Executor;
import com.win.muzikrestpack.domain.executor.MainThread;
import com.win.muzikrestpack.domain.interactors.GetArtistModelByIdInteractor;
import com.win.muzikrestpack.domain.interactors.GetSongModelByArtistIdInteractor;
import com.win.muzikrestpack.domain.interactors.impl.Artist.GetArtistModelByIdInteractorImpl;
import com.win.muzikrestpack.domain.interactors.impl.Song.GetSongModelByArtistIdInteractorImpl;
import com.win.muzikrestpack.domain.model.ArtistModel;
import com.win.muzikrestpack.domain.model.SongModel;
import com.win.muzikrestpack.domain.repository.ArtistRepository;
import com.win.muzikrestpack.domain.repository.SongRepository;
import com.win.muzikrestpack.presentation.presenters.AbstractPresenter;
import com.win.muzikrestpack.presentation.presenters.ArtistDetailPresenter;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by win on 3/26/17.
 */

public class ArtistDetailPresenterImpl extends AbstractPresenter implements ArtistDetailPresenter, GetSongModelByArtistIdInteractor.Callback, GetArtistModelByIdInteractor.Callback {
    private ArtistDetailPresenter.View mView;
    private ArtistRepository mArtistRepository;
    private SongRepository mSongRepository;

    /**
     * @param executor
     * @param mainThread
     * @param view
     * @param artistRepository
     * @param songRepository
     */
    public ArtistDetailPresenterImpl(Executor executor, MainThread mainThread, View view, ArtistRepository artistRepository, SongRepository songRepository) {
        super(executor, mainThread);
        mView = view;
        mArtistRepository = artistRepository;
        mSongRepository = songRepository;
    }

    @Override
    public void onSongModelRetrieved(Observable<SongModel> songModelObservable) {
        songModelObservable.subscribe(new Consumer<SongModel>() {
            @Override
            public void accept(SongModel songModel) throws Exception {
                mView.onSongListRetrieved(songModel.getSongs());
            }
        });
    }

    @Override
    public void onArtistModelByIdRetrieved(Observable<ArtistModel> artistModel) {
        artistModel.subscribe(new Consumer<ArtistModel>() {
            @Override
            public void accept(ArtistModel artistModel) throws Exception {
                mView.onArtistModelRetrieved(artistModel.getArtists().get(0));
            }
        });
    }

    @Override
    public void getArtistModel(String id) {
        GetArtistModelByIdInteractor getArtistModelByIdInteractor = new GetArtistModelByIdInteractorImpl(
                mExecutor, mMainThread, mArtistRepository, id, this);
        getArtistModelByIdInteractor.execute();
    }

    @Override
    public void getSongModelByArtistId(String page, String artistId) {
        GetSongModelByArtistIdInteractor getSongModelByArtistIdInteractor = new GetSongModelByArtistIdInteractorImpl(
                mExecutor, mMainThread, mSongRepository, page, artistId, this);
        getSongModelByArtistIdInteractor.execute();

    }
}
