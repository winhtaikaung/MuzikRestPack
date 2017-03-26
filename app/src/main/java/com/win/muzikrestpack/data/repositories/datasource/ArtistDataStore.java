package com.win.muzikrestpack.data.repositories.datasource;

import com.win.muzikrestpack.data.network.model.RESTArtistModel;

import io.reactivex.Observable;

/**
 * Created by win on 3/22/17.
 */

public interface ArtistDataStore {

    Observable<RESTArtistModel> getArtist(String artistId);

    Observable<RESTArtistModel> getArtistModel(String page, String artistId);
}
