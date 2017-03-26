package com.win.muzikrestpack.presentation.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.win.muzikrestpack.R;
import com.win.muzikrestpack.presentation.ui.adapters.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private final String[] titles={"Songs","Artists"};
    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.pager) ViewPager mPager;
    @BindView(R.id.tabs) TabLayout mTabLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),titles);
        mPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mPager);

                //TODO presentation layer to be implemented
//        ArtistDataStoreFactory dataStoreFactory = new ArtistDataStoreFactory();
//        ArtistDataRepository dataRepo = new ArtistDataRepository(dataStoreFactory, new RESTArtistModelConverter());
//        Observable<ArtistModel> flight = dataRepo.getAllArtistModel("1", "3");
//        flight.subscribe(new Consumer<ArtistModel>() {
//            @Override
//            public void accept(ArtistModel artistModel) throws Exception {
//                Log.e("data", artistModel.getArtists().get(0).getName());
//            }
//        });
//
//        final SongDataStoreFactory songDataStoreFactory = new SongDataStoreFactory();
//        SongDataRepository songdataRepo = new SongDataRepository(songDataStoreFactory, new RESTSongModelConverter());
//
//        Observable<SongModel> songModel = songdataRepo.getSongs("1","3");
//        songModel.subscribe(new Consumer<SongModel>() {
//            @Override
//            public void accept(SongModel songModel) throws Exception {
//                GetAllSongModelnteractorImpl interactor = new GetAllSongModelnteractorImpl(ThreadExecutor.getInstance()
//                        , MainThreadImpl.getInstance(),new SongDataRepository(songDataStoreFactory,new RESTSongModelConverter()) , "1","2" , GetAllSongModelInteractor.Callback)
//            }
//        });

    }


}
