package com.win.muzikrestpack.data.repositories.datasource;

import com.win.muzikrestpack.data.network.model.RESTArtist;
import com.win.muzikrestpack.data.network.model.RESTArtistModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by win on 3/22/17.
 */

public interface ArtistDataStore {

    Observable<RESTArtist> getArtist();

    Observable<List<RESTArtist>> getArtists();

    Observable<RESTArtistModel> getArtistModel(String page,String artistId);
}
