package com.win.muzikrestpack.data.repositories.datasource;

import com.win.muzikrestpack.data.network.model.RESTSongModel;

import io.reactivex.Observable;

/**
 * Created by win on 3/22/17.
 */

public interface SongDataStore {

    Observable<RESTSongModel> getSongs(String page, String artistId);

    Observable<RESTSongModel> getSong(String songId);
}
