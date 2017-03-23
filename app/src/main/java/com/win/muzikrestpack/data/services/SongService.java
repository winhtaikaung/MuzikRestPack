package com.win.muzikrestpack.data.services;

import com.win.muzikrestpack.data.network.Endpoints;
import com.win.muzikrestpack.data.network.model.RESTSongModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by win on 3/23/17.
 */

public interface SongService {

    @GET(Endpoints.SONG_API)
    Observable<RESTSongModel> getSongs(@Query("page") String Page,
                                       @Query("artist_ids") String ArtistId);

    @GET(Endpoints.SONG_API)
    Observable<RESTSongModel> getSong(@Query("ids") String songId);
}
