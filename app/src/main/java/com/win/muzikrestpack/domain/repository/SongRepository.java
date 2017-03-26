package com.win.muzikrestpack.domain.repository;

import com.win.muzikrestpack.domain.model.SongModel;

import io.reactivex.Observable;

/**
 * Created by win on 3/24/17.
 */

public interface SongRepository {


    Observable<SongModel> getSongsByArtistId(String page, String artistId);

    Observable<SongModel> getSongs(String page,String pageSize);

    Observable<SongModel> getSong(String songId);

}
