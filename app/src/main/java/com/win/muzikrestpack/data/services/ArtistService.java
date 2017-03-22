package com.win.muzikrestpack.data.services;

import com.win.muzikrestpack.data.network.Endpoints;
import com.win.muzikrestpack.data.network.model.RESTArtist;
import com.win.muzikrestpack.data.network.model.RESTArtistModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by win on 3/22/17.
 */

public interface ArtistService {

    @GET
    Observable<RESTArtist> getArtist();

    @GET
    Observable<List<RESTArtist>> getArtistList();

    @GET(Endpoints.ARTIST_API)
    Observable<RESTArtistModel> getArtistModel(@Query("page") String Page,
                                               @Query("ids") String ArtistId);
}
