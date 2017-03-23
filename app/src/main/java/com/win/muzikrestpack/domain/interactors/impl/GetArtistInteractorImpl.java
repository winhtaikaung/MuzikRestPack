package com.win.muzikrestpack.domain.interactors.impl;

import com.win.muzikrestpack.domain.executor.Executor;
import com.win.muzikrestpack.domain.executor.MainThread;
import com.win.muzikrestpack.domain.interactors.GetArtistInteractor;
import com.win.muzikrestpack.domain.interactors.base.AbstractInteractor;
import com.win.muzikrestpack.domain.repository.ArtistRepository;

import io.reactivex.Observable;

import com.win.muzikrestpack.domain.model.Artist;

/**
 * Created by winhtaikaung on 20/3/17.
 */

public class GetArtistInteractorImpl extends AbstractInteractor implements GetArtistInteractor {
    private ArtistRepository mArtistRepository;
    private Callback mCallback;

    public GetArtistInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                   ArtistRepository artistRepository,
                                   Callback callback) {
        super(threadExecutor, mainThread);
        mArtistRepository = artistRepository;
        mCallback = callback;

    }

    @Override
    public void run() {
        final Observable<Artist> artists = mArtistRepository.getArtist();

        // Show costs on the main thread
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onArtistRetrieved(artists);
            }
        });
    }
}
