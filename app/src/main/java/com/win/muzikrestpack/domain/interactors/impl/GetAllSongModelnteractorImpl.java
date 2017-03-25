package com.win.muzikrestpack.domain.interactors.impl;

import com.win.muzikrestpack.domain.executor.Executor;
import com.win.muzikrestpack.domain.executor.MainThread;
import com.win.muzikrestpack.domain.interactors.GetAllSongModeldInteractor;
import com.win.muzikrestpack.domain.interactors.base.AbstractInteractor;
import com.win.muzikrestpack.domain.model.SongModel;
import com.win.muzikrestpack.domain.repository.SongRepository;

import io.reactivex.Observable;

/**
 * Created by win on 3/24/17.
 */

public class GetAllSongModelnteractorImpl extends AbstractInteractor implements GetAllSongModeldInteractor {

    private SongRepository mSongRepository;
    private Callback mCallback;

    private String page;
    private String pageSize;

    public GetAllSongModelnteractorImpl(Executor threadExecutor, MainThread mainThread,
                                        SongRepository songRepository, String page, String pagesize,
                                        Callback callback) {
        super(threadExecutor, mainThread);
        mSongRepository = songRepository;
        mCallback = callback;
        this.page = page;
        this.pageSize = pagesize;

    }

    @Override
    public void run() {
        final Observable<SongModel> artists = mSongRepository.getSongs(page, pageSize);

        // Show costs on the main thread
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onAllSongModelRetrieved(artists);
            }
        });
    }
}
