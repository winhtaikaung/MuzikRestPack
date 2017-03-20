package com.win.muzikrestpack.domain.interactor;

import com.win.muzikrestpack.threading.TestMainThread;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import domain.executor.Executor;
import domain.executor.MainThread;
import domain.interactors.GetArtistInteractor;
import domain.interactors.impl.GetArtistInteractorImpl;
import domain.interactors.repository.ArtistRepository;
import io.reactivex.Observable;
import model.Artist;

import static org.mockito.Mockito.when;

/**
 * Created by winhtaikaung on 20/3/17.
 */

public class GetArtistInteractorTest {

    private MainThread mMainThread;
    @Mock
    private Executor mExecutor;
    @Mock
    private ArtistRepository mArtistRepository;
    @Mock
    private GetArtistInteractor.Callback mMockedCallback;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mMainThread = new TestMainThread();
    }


    @Test
    public void testGetArtist() throws Exception {

        Artist dummyArtist = new Artist("1", "Mona", "http://ab.com", "http://www.flightstatus.com"
        );


        Observable<Artist> dummyObservableFlight = Observable.just(dummyArtist);
        when(mArtistRepository.getArtist())
                .thenReturn(dummyObservableFlight);

        GetArtistInteractorImpl interactor = new GetArtistInteractorImpl(mExecutor, mMainThread, mArtistRepository, mMockedCallback);
        interactor.run();

        Mockito.verify(mArtistRepository).getArtist();
        Mockito.verifyNoMoreInteractions(mArtistRepository);
        Mockito.verify(mMockedCallback).onArtistRetrieved(dummyObservableFlight);

    }
}
