package com.win.muzikrestpack.domain.interactors;

import com.win.muzikrestpack.domain.model.SongModel;

import io.reactivex.Observable;

/**
 * Created by win on 3/24/17.
 */

public interface GetAllSongModeldInteractor {
    interface Callback {
        void onAllSongModelRetrieved(Observable<SongModel> songModelObservable);
    }
}
