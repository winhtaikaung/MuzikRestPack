package com.win.muzikrestpack.domain.interactor;

import com.win.muzikrestpack.domain.executor.Executor;
import com.win.muzikrestpack.domain.executor.MainThread;
import com.win.muzikrestpack.domain.interactors.GetSongModelByArtistIdInteractor;
import com.win.muzikrestpack.domain.interactors.impl.Song.GetSongModelByArtistIdInteractorImpl;
import com.win.muzikrestpack.domain.model.Artists;
import com.win.muzikrestpack.domain.model.Links;
import com.win.muzikrestpack.domain.model.Links_;
import com.win.muzikrestpack.domain.model.Meta;
import com.win.muzikrestpack.domain.model.Song;
import com.win.muzikrestpack.domain.model.SongModel;
import com.win.muzikrestpack.domain.model.SongsAlbum;
import com.win.muzikrestpack.domain.model.SongsArtist;
import com.win.muzikrestpack.domain.repository.SongRepository;
import com.win.muzikrestpack.threading.TestMainThread;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static org.mockito.Mockito.when;

/**
 * Created by win on 3/24/17.
 */

public class GetSongModelByArtistIdInteractorTest {

    private MainThread mMainThread;
    @Mock
    private Executor mExecutor;
    @Mock
    private SongRepository mSongRepository;
    @Mock
    private GetSongModelByArtistIdInteractor.Callback mMockedCallback;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mMainThread = new TestMainThread();
    }

    @Test
    public void testGetSongByArtistID() throws Exception {

        Song dummySongfirst = new Song("1", "Mona", "http://ab.com", new Links("1", "1")
        );
        Song dummySongsecond = new Song("1", "Mona", "http://ab.com", new Links("2", "2")
        );
        Song dummySongthird = new Song("1", "Mona", "http://ab.com", new Links("3", "3")
        );

        List<Song> dummySongList = new ArrayList<>();
        dummySongList.add(dummySongfirst);
        dummySongList.add(dummySongsecond);
        dummySongList.add(dummySongthird);

        Links_ links = new Links_(new SongsArtist("http://abc.com", "demotype"), new SongsAlbum("http://abc.com", "demotype"));
        Meta meta = new Meta(new Artists(1, 3, new ArrayList(), 3, 1, 3, "http://nextpage.com", "http://prevpage.com"));
        SongModel dummyModel = new SongModel(dummySongList, links, meta);

        Observable<SongModel> dummySongModelObservable = Observable.just(dummyModel);

        when(mSongRepository.getSongsByArtistId(String.valueOf(1), dummySongfirst.getId()))
                .thenReturn(dummySongModelObservable);

        GetSongModelByArtistIdInteractorImpl interactor = new GetSongModelByArtistIdInteractorImpl(mExecutor, mMainThread, mSongRepository, "1", dummySongfirst.getId(), mMockedCallback);
        interactor.run();
        Mockito.verify(mSongRepository).getSongsByArtistId(String.valueOf(1), dummySongfirst.getId());
        Mockito.verifyNoMoreInteractions(mSongRepository);
        Mockito.verify(mMockedCallback).onSongModelRetrieved(dummySongModelObservable);

    }


}
