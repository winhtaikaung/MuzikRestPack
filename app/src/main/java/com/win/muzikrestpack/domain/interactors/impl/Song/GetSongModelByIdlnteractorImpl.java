package com.win.muzikrestpack.domain.interactors.impl.Song;

import com.win.muzikrestpack.domain.executor.Executor;
import com.win.muzikrestpack.domain.executor.MainThread;
import com.win.muzikrestpack.domain.interactors.GetSongModelByIdInteractor;
import com.win.muzikrestpack.domain.interactors.base.AbstractInteractor;
import com.win.muzikrestpack.domain.model.SongModel;
import com.win.muzikrestpack.domain.repository.SongRepository;

import io.reactivex.Observable;

/**
 * Created by win on 3/24/17.
 */

public class GetSongModelByIdlnteractorImpl extends AbstractInteractor implements GetSongModelByIdInteractor {

    private SongRepository mSongRepository;
    private Callback mCallback;

    private String songId;

    /**
     * @param threadExecutor
     * @param mainThread
     * @param songRepository
     * @param songId
     * @param callback
     */
    public GetSongModelByIdlnteractorImpl(Executor threadExecutor, MainThread mainThread,
                                          SongRepository songRepository, String songId,
                                          Callback callback) {
        super(threadExecutor, mainThread);
        mSongRepository = songRepository;
        mCallback = callback;
        this.songId = songId;

    }

    @Override
    public void run() {
        final Observable<SongModel> artists = mSongRepository.getSong(songId);

        // Show costs on the main thread
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onSongModelByIdRetrieved(artists);
            }
        });
    }
}
