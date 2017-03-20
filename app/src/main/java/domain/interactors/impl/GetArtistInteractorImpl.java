package domain.interactors.impl;

import domain.executor.Executor;
import domain.executor.MainThread;
import domain.interactors.GetArtistInteractor;
import domain.interactors.base.AbstractInteractor;
import domain.interactors.repository.ArtistRepository;
import io.reactivex.Observable;
import model.Artist;

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
