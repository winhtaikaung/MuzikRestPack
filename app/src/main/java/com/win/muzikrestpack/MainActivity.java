package com.win.muzikrestpack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.win.muzikrestpack.data.network.converter.RESTArtistModelConverter;
import com.win.muzikrestpack.data.repositories.ArtistDataRepository;
import com.win.muzikrestpack.data.repositories.datasource.ArtistDataStoreFactory;
import com.win.muzikrestpack.domain.model.ArtistModel;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO presentation layer to be implemented
        ArtistDataStoreFactory dataStoreFactory = new ArtistDataStoreFactory();
        ArtistDataRepository dataRepo = new ArtistDataRepository(dataStoreFactory, new RESTArtistModelConverter());
        Observable<ArtistModel> flight = dataRepo.getArtistModel("1", "3");
        flight.subscribe(new Consumer<ArtistModel>() {
            @Override
            public void accept(ArtistModel artistModel) throws Exception {
                Log.e("data",artistModel.getArtists().get(0).getName());
            }
        });
    }
}
