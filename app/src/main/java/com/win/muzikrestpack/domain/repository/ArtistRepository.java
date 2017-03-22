package com.win.muzikrestpack.domain.repository;

import com.win.muzikrestpack.domain.model.Artist;
import com.win.muzikrestpack.domain.model.ArtistModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 20/3/17.
 * This class stand as contract in ArtistRepository
 */

public interface ArtistRepository {

    Observable<Artist> getArtist();

    Observable<List<Artist>> getArtists();

    Observable<ArtistModel> getArtistModel(String page, String artistId);
}
