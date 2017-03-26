package com.win.muzikrestpack.domain.repository;

import com.win.muzikrestpack.domain.model.ArtistModel;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 20/3/17.
 * This class stand as contract in ArtistRepository
 */

public interface ArtistRepository {

    Observable<ArtistModel> getArtist(String artistId);


    Observable<ArtistModel> getAllArtistModel(String page, String pageSize);
}
