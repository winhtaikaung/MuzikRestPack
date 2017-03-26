package com.win.muzikrestpack.domain.interactors.impl.Song;

import com.win.muzikrestpack.domain.executor.Executor;
import com.win.muzikrestpack.domain.executor.MainThread;
import com.win.muzikrestpack.domain.interactors.GetSongModelByArtistIdInteractor;
import com.win.muzikrestpack.domain.interactors.base.AbstractInteractor;
import com.win.muzikrestpack.domain.model.SongModel;
import com.win.muzikrestpack.domain.repository.SongRepository;

import io.reactivex.Observable;

/**
 * Created by win on 3/24/17.
 */

public class GetSongModelByArtistIdInteractorImpl extends AbstractInteractor implements GetSongModelByArtistIdInteractor {

    private SongRepository mSongRepository;
    private GetSongModelByArtistIdInteractor.Callback mCallback;

    private String page;
    private String artistId;

    /**
     *
     * @param threadExecutor
     * @param mainThread
     * @param songRepository
     * @param page
     * @param artistId
     * @param callback
     */
    public GetSongModelByArtistIdInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                                SongRepository songRepository, String page, String artistId,
                                                GetSongModelByArtistIdInteractor.Callback callback) {
        super(threadExecutor, mainThread);
        mSongRepository = songRepository;
        mCallback = callback;
        this.page = page;
        this.artistId = artistId;

    }

    @Override
    public void run() {
        final Observable<SongModel> artists = mSongRepository.getSongsByArtistId(page, artistId);

        // Show costs on the main thread
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onSongModelRetrieved(artists);
            }
        });
    }
}
