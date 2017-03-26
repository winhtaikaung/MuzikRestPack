package com.win.muzikrestpack.data.repositories;

import com.win.muzikrestpack.data.network.converter.RESTArtistModelConverter;
import com.win.muzikrestpack.data.network.model.RESTArtistModel;
import com.win.muzikrestpack.data.repositories.datasource.ArtistDataStoreFactory;
import com.win.muzikrestpack.domain.model.ArtistModel;
import com.win.muzikrestpack.domain.repository.ArtistRepository;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by win on 3/22/17.
 * This Repository is responsible as a repository between business domain and data Layer
 */

public class ArtistDataRepository implements ArtistRepository {

    private final RESTArtistModelConverter restArtistModelConverter;
    private final ArtistDataStoreFactory artistDataStoreFactory;

    /**
     *
     * @param artistDataStoreFactory
     * @param restArtistModelConverter
     */
    public ArtistDataRepository(ArtistDataStoreFactory artistDataStoreFactory, RESTArtistModelConverter restArtistModelConverter) {
        this.restArtistModelConverter = restArtistModelConverter;
        this.artistDataStoreFactory = artistDataStoreFactory;
    }

    @Override
    public Observable<ArtistModel> getArtist(String artistId) {
        return artistDataStoreFactory.create().getArtist(artistId).map(new Function<RESTArtistModel, ArtistModel>() {
            @Override
            public ArtistModel apply(RESTArtistModel restArtistModel) throws Exception {
                return restArtistModelConverter.convertToArtistModel(restArtistModel);

            }
        });
    }

    @Override
    public Observable<ArtistModel> getAllArtistModel(String page, String pageSize) {

        return artistDataStoreFactory.create().getArtistModel(page, pageSize).map(new Function<RESTArtistModel, ArtistModel>() {
            @Override
            public ArtistModel apply(RESTArtistModel restArtistModel) throws Exception {
                return restArtistModelConverter.convertToArtistModel(restArtistModel);
            }
        });
    }


}
