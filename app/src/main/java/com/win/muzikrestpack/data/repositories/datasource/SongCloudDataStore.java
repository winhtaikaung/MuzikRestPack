package com.win.muzikrestpack.data.repositories.datasource;

import com.win.muzikrestpack.data.network.model.RESTSongModel;
import com.win.muzikrestpack.data.services.SongService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.win.muzikrestpack.data.network.RestClient.getRetrofit;

/**
 * Created by win on 3/22/17.
 */

public class SongCloudDataStore implements SongDataStore {

    private final String TAG = "SONG_CLOUD_DS";

    public SongCloudDataStore() {

    }


    @Override
    public Observable<RESTSongModel> getSongs(String page, String artistId) {
        return getRetrofit().create(SongService.class).getSongs(page, artistId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<RESTSongModel>() {
                    @Override
                    public void accept(RESTSongModel restSongModel) throws Exception {
//                        Log.e(TAG + "Model", restSongModel.getRESTMeta().getArtists().toString());
                    }
                });
    }

    @Override
    public Observable<RESTSongModel> getSong(String songId) {
        return getRetrofit().create(SongService.class).getSong(songId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<RESTSongModel>() {
                    @Override
                    public void accept(RESTSongModel restSongModel) throws Exception {
//                        Log.e(TAG + "Model", restSongModel.getRESTMeta().getArtists().toString());
                    }
                });
    }
}
