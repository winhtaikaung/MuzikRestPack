package com.win.muzikrestpack.domain.interactors.impl;

import java.util.List;

import com.win.muzikrestpack.domain.executor.Executor;
import com.win.muzikrestpack.domain.executor.MainThread;
import com.win.muzikrestpack.domain.interactors.GetArtistListInteractor;
import com.win.muzikrestpack.domain.interactors.base.AbstractInteractor;
import com.win.muzikrestpack.domain.repository.ArtistRepository;
import io.reactivex.Observable;
import com.win.muzikrestpack.domain.model.Artist;

/**
 * Created by winhtaikaung on 20/3/17.
 */

public class GetArtistListInteractorImpl extends AbstractInteractor implements GetArtistListInteractor {
    private ArtistRepository mArtistRepository;
    private GetArtistListInteractor.Callback mCallback;

    public GetArtistListInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                       ArtistRepository artistRepository,
                                       GetArtistListInteractor.Callback callback) {
        super(threadExecutor, mainThread);
        mArtistRepository = artistRepository;
        mCallback = callback;

    }

    @Override
    public void run() {
        final Observable<List<Artist>> artists = mArtistRepository.getArtists();

        // Show costs on the main thread
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onArtistListRetrieved(artists);
            }
        });
    }
}
