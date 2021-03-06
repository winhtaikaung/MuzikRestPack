package com.win.muzikrestpack.data.repositories.datasource;

import android.util.Log;

import com.win.muzikrestpack.data.network.model.RESTArtistModel;
import com.win.muzikrestpack.data.services.ArtistService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.win.muzikrestpack.data.network.RestClient.getRetrofit;

/**
 * Created by win on 3/22/17.
 */

public class ArtistCloudDataStore implements ArtistDataStore {

    private final String TAG = "ARTIST_CLOUD_DS";

    public ArtistCloudDataStore() {

    }


    @Override
    public Observable<RESTArtistModel> getArtist(String artistId) {
        return getRetrofit().create(ArtistService.class).getArtist(artistId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<RESTArtistModel>() {
                    @Override
                    public void accept(RESTArtistModel restArtistModel) throws Exception {
                        Log.e(TAG + "artist", restArtistModel.toString());
                    }
                });
    }


    @Override
    public Observable<RESTArtistModel> getArtistModel(String page, String artistId) {
        return getRetrofit().create(ArtistService.class).getArtistModel(page, artistId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<RESTArtistModel>() {
                    @Override
                    public void accept(RESTArtistModel restArtistModel) throws Exception {
                        Log.e(TAG + "Model", restArtistModel.getMeta().getArtists().toString());
                    }
                });
    }
}
