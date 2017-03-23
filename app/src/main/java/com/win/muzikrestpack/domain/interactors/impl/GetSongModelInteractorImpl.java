package com.win.muzikrestpack.domain.interactors.impl;

import com.win.muzikrestpack.domain.executor.Executor;
import com.win.muzikrestpack.domain.executor.MainThread;
import com.win.muzikrestpack.domain.interactors.GetSongModelInteractor;
import com.win.muzikrestpack.domain.interactors.base.AbstractInteractor;
import com.win.muzikrestpack.domain.model.SongModel;
import com.win.muzikrestpack.domain.repository.SongRepository;

import io.reactivex.Observable;

/**
 * Created by win on 3/24/17.
 */

public class GetSongModelInteractorImpl extends AbstractInteractor implements GetSongModelInteractor {

    private SongRepository mSongRepository;
    private GetSongModelInteractor.Callback mCallback;

    private String page;
    private String artistId;

    public GetSongModelInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                      SongRepository songRepository, String page, String artistId,
                                      GetSongModelInteractor.Callback callback) {
        super(threadExecutor, mainThread);
        mSongRepository = songRepository;
        mCallback = callback;
        this.page = page;
        this.artistId = artistId;

    }

    @Override
    public void run() {
        final Observable<SongModel> artists = mSongRepository.getSongs(page, artistId);

        // Show costs on the main thread
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onSongModelRetrieved(artists);
            }
        });
    }
}
