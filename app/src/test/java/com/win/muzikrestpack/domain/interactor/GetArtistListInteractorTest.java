package com.win.muzikrestpack.domain.interactor;

import com.win.muzikrestpack.domain.executor.Executor;
import com.win.muzikrestpack.domain.executor.MainThread;
import com.win.muzikrestpack.domain.interactors.GetArtistListInteractor;
import com.win.muzikrestpack.domain.interactors.impl.GetArtistListInteractorImpl;
import com.win.muzikrestpack.domain.model.Artist;
import com.win.muzikrestpack.domain.repository.ArtistRepository;
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
 * Created by winhtaikaung on 20/3/17.
 */

public class GetArtistListInteractorTest {

    private MainThread mMainThread;
    @Mock
    private Executor mExecutor;
    @Mock
    private ArtistRepository mArtistRepository;
    @Mock
    private GetArtistListInteractor.Callback mMockedCallback;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mMainThread = new TestMainThread();
    }


    @Test
    public void testGetArtist() throws Exception {

        Artist dummyArtistfirst = new Artist("1", "Mona", "http://ab.com", "http://www.flightstatus.com"
        );
        Artist dummyArtistsecond= new Artist("1", "Mona", "http://ab.com", "http://www.flightstatus.com"
        );
        Artist dummyArtistthird = new Artist("1", "Mona", "http://ab.com", "http://www.flightstatus.com"
        );
        List<Artist> dummyArtistList = new ArrayList<>();
        dummyArtistList.add(dummyArtistfirst);
        dummyArtistList.add(dummyArtistsecond);
        dummyArtistList.add(dummyArtistthird);

        Observable<List<Artist>> dummyObservableFlightlist = Observable.just(dummyArtistList);
        when(mArtistRepository.getArtists())
                .thenReturn(dummyObservableFlightlist);

        GetArtistListInteractorImpl interactor = new GetArtistListInteractorImpl(mExecutor, mMainThread, mArtistRepository, mMockedCallback);
        interactor.run();
        Mockito.verify(mArtistRepository).getArtists();
        Mockito.verifyNoMoreInteractions(mArtistRepository);
        Mockito.verify(mMockedCallback).onArtistListRetrieved(dummyObservableFlightlist);

    }
}
