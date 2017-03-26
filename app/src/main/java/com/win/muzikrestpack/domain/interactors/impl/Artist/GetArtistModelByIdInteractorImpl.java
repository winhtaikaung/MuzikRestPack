package com.win.muzikrestpack.domain.interactors.impl.Artist;

import com.win.muzikrestpack.domain.executor.Executor;
import com.win.muzikrestpack.domain.executor.MainThread;
import com.win.muzikrestpack.domain.interactors.GetArtistModelByIdInteractor;
import com.win.muzikrestpack.domain.interactors.base.AbstractInteractor;
import com.win.muzikrestpack.domain.model.ArtistModel;
import com.win.muzikrestpack.domain.repository.ArtistRepository;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 20/3/17.
 */

public class GetArtistModelByIdInteractorImpl extends AbstractInteractor implements GetArtistModelByIdInteractor {
    private ArtistRepository mArtistRepository;
    private Callback mCallback;

    private String page;
    private String artistId;

    /**
     * @param threadExecutor
     * @param mainThread
     * @param artistRepository
     * @param artistId
     * @param callback
     */
    public GetArtistModelByIdInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                            ArtistRepository artistRepository, String artistId,
                                            Callback callback) {
        super(threadExecutor, mainThread);
        mArtistRepository = artistRepository;
        mCallback = callback;
        this.artistId = artistId;

    }

    @Override
    public void run() {
        final Observable<ArtistModel> artists = mArtistRepository.getArtist(artistId);

        // Show costs on the main thread
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onArtistModelByIdRetrieved(artists);
            }
        });
    }
}
