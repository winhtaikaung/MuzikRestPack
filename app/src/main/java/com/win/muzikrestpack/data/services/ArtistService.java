package com.win.muzikrestpack.data.services;

import com.win.muzikrestpack.data.network.Endpoints;
import com.win.muzikrestpack.data.network.model.RESTArtistModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by win on 3/22/17.
 */

public interface ArtistService {

    @GET(Endpoints.ARTIST_API)
    Observable<RESTArtistModel> getArtist(@Query("ids") String artistId);


    @GET(Endpoints.ARTIST_API)
    Observable<RESTArtistModel> getArtistModel(@Query("page") String Page,
                                               @Query("page_size") String pageSize);
}
