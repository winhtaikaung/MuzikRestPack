package com.win.muzikrestpack.presentation.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;

import com.win.muzikrestpack.R;
import com.win.muzikrestpack.data.network.converter.RESTArtistModelConverter;
import com.win.muzikrestpack.data.network.converter.RESTSongModelConverter;
import com.win.muzikrestpack.data.repositories.ArtistDataRepository;
import com.win.muzikrestpack.data.repositories.SongDataRepository;
import com.win.muzikrestpack.data.repositories.datasource.ArtistDataStoreFactory;
import com.win.muzikrestpack.data.repositories.datasource.SongDataStoreFactory;
import com.win.muzikrestpack.domain.executor.impl.ThreadExecutor;
import com.win.muzikrestpack.domain.model.Artist;
import com.win.muzikrestpack.domain.model.Song;
import com.win.muzikrestpack.presentation.presenters.ArtistDetailPresenter;
import com.win.muzikrestpack.presentation.presenters.impl.ArtistDetailPresenterImpl;
import com.win.muzikrestpack.presentation.ui.adapters.ArtistDetailAdapter;
import com.win.muzikrestpack.presentation.ui.base.SectionView;
import com.win.muzikrestpack.threading.MainThreadImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

public class ArtistDetailActivity extends AppCompatActivity implements ArtistDetailPresenter.View {

    List<SectionView> sectionList = new ArrayList<>();
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.detailRecyclerView)
    RecyclerView mDetailRecyclerView;

    LinearLayoutManager layoutManager;
    ArtistDetailAdapter mArtistDetailAdapter;

    Observable<Artist> mObservableArtist;
    Observable<List<Song>> mObservableListSong;
    //TODO http://square.github.io/dagger/ has to utilize for dependencies injection
    private ArtistDetailPresenter mArtistDetailPresenter;

    private SongDataStoreFactory songDataStoreFactory;
    private SongDataRepository songDataRepository;

    private ArtistDataStoreFactory artistDataStoreFactory;
    private ArtistDataRepository artistDataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_detail);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        //TODO receive data from ListOnclick


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        songDataStoreFactory = new SongDataStoreFactory();
        songDataRepository = new SongDataRepository(songDataStoreFactory, new RESTSongModelConverter());

        artistDataStoreFactory = new ArtistDataStoreFactory();
        artistDataRepository = new ArtistDataRepository(artistDataStoreFactory, new RESTArtistModelConverter());

        mArtistDetailPresenter = new ArtistDetailPresenterImpl(ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this,
                artistDataRepository, songDataRepository);

        Intent intent = getIntent();
        final String artistId = TextUtils.isEmpty(intent.getStringExtra("ARTIST_ID")) ? "1" : intent.getStringExtra("ARTIST_ID");
        fetchDataByMessagingThread(artistId);

        layoutManager = new LinearLayoutManager(this);





    }

    @Override
    public void onArtistModelRetrieved(final Artist artist) {
        Log.e("ARTIST_DETAIL", artist.getName());
        getSupportActionBar().setTitle(artist.getName());
        mObservableArtist = Observable.just(artist);
        //Observing Sections items
        mArtistDetailPresenter.getSongModelByArtistId("1", artist.getId());

    }

    @Override
    public void onSongListRetrieved(List<Song> songList) {
        Log.e("ARTIST_DETAIL", String.valueOf(songList.size()));
        //Observing Sections items
        mObservableListSong = Observable.just(songList);
        Observable<List<SectionView>> sectionListObservable = Observable.zip(mObservableArtist, mObservableListSong, new BiFunction<Artist, List<Song>, List<SectionView>>() {
            @Override
            public List<SectionView> apply(Artist artist, List<Song> songs) throws Exception {
                sectionList.add(new SectionView(artist, false));
                sectionList.add(new SectionView(songs, false));
                Log.e("SECTION_VIEW", artist.getName() + "-------" + songs.get(0).getTitle());
                return sectionList;
            }
        });

        sectionListObservable.subscribe(new Consumer<List<SectionView>>() {
            @Override
            public void accept(List<SectionView> sectionViewList) throws Exception {
                mArtistDetailAdapter = new ArtistDetailAdapter(sectionViewList);
                mDetailRecyclerView.setLayoutManager(layoutManager);

                mDetailRecyclerView.setAdapter(mArtistDetailAdapter);
                mDetailRecyclerView.getLayoutManager().scrollToPosition(0);
                Log.e("SECTION_VIEW", String.valueOf(sectionViewList.size()));
            }
        });

    }

    void fetchDataByMessagingThread(final String artistId) {
        mArtistDetailPresenter.getArtistModel(artistId);



    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void hideError(String message) {

    }
}
