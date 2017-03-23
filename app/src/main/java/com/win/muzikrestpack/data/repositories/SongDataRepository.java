package com.win.muzikrestpack.data.repositories;

import com.win.muzikrestpack.data.network.converter.RESTSongModelConverter;
import com.win.muzikrestpack.data.network.model.RESTSongModel;
import com.win.muzikrestpack.data.repositories.datasource.SongDataStoreFactory;
import com.win.muzikrestpack.domain.model.SongModel;
import com.win.muzikrestpack.domain.repository.SongRepository;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by win on 3/24/17.
 */

public class SongDataRepository implements SongRepository {
    private final RESTSongModelConverter restSongModelConverter;
    private final SongDataStoreFactory songDataStoreFactory;

    public SongDataRepository(SongDataStoreFactory songDataStoreFactory, RESTSongModelConverter restSongModelConverter) {
        this.restSongModelConverter = restSongModelConverter;
        this.songDataStoreFactory = songDataStoreFactory;
    }


    @Override
    public Observable<SongModel> getSongs(String page, String artistId) {
        return songDataStoreFactory.create().getSongs(page, artistId).map(new Function<RESTSongModel, SongModel>() {
            @Override
            public SongModel apply(RESTSongModel restSongModel) throws Exception {
                return restSongModelConverter.convertToSongModel(restSongModel);
            }
        });
    }

    @Override
    public Observable<SongModel> getSong(String songId) {
        return songDataStoreFactory.create().getSong(songId).map(new Function<RESTSongModel, SongModel>() {
            @Override
            public SongModel apply(RESTSongModel restSongModel) throws Exception {
                return restSongModelConverter.convertToSongModel(restSongModel);
            }
        });
    }

}
