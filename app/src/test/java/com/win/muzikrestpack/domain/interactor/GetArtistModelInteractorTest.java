package com.win.muzikrestpack.domain.interactor;

import com.win.muzikrestpack.threading.TestMainThread;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import com.win.muzikrestpack.domain.executor.Executor;
import com.win.muzikrestpack.domain.executor.MainThread;
import com.win.muzikrestpack.domain.interactors.GetArtistModelInteractor;
import com.win.muzikrestpack.domain.interactors.impl.GetArtistModelInteractorImpl;
import com.win.muzikrestpack.domain.repository.ArtistRepository;
import io.reactivex.Observable;
import com.win.muzikrestpack.domain.model.Artist;
import com.win.muzikrestpack.domain.model.ArtistModel;
import com.win.muzikrestpack.domain.model.Artists;
import com.win.muzikrestpack.domain.model.ArtistsAlbums;
import com.win.muzikrestpack.domain.model.ArtistsSongs;
import com.win.muzikrestpack.domain.model.Links;
import com.win.muzikrestpack.domain.model.Meta;

import static org.mockito.Mockito.when;

/**
 * Created by winhtaikaung on 20/3/17.
 */

public class GetArtistModelInteractorTest {

    private MainThread mMainThread;
    @Mock
    private Executor mExecutor;
    @Mock
    private ArtistRepository mArtistRepository;
    @Mock
    private GetArtistModelInteractor.Callback mMockedCallback;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mMainThread = new TestMainThread();
    }


    @Test
    public void testGetArtistModel() throws Exception {

        Artist dummyArtistfirst = new Artist("1", "Mona", "http://ab.com", "http://www.flightstatus.com"
        );
        Artist dummyArtistsecond = new Artist("1", "Mona", "http://ab.com", "http://www.flightstatus.com"
        );
        Artist dummyArtistthird = new Artist("1", "Mona", "http://ab.com", "http://www.flightstatus.com"
        );

        List<Artist> dummyArtistList = new ArrayList<>();
        dummyArtistList.add(dummyArtistfirst);
        dummyArtistList.add(dummyArtistsecond);
        dummyArtistList.add(dummyArtistthird);

        Links links = new Links(new ArtistsAlbums("http://abc.com", "demotype"), new ArtistsSongs("http://abc.com", "demotype"));
        Meta meta = new Meta(new Artists(1, 3, new ArrayList(), 3, 1, 3, "http://nextpage.com", "http://prevpage.com"));
        ArtistModel dummyModel = new ArtistModel(dummyArtistList, links, meta);

        Observable<ArtistModel> dummyArtistModel = Observable.just(dummyModel);

        when(mArtistRepository.getArtistModel(String.valueOf(1),dummyArtistfirst.getId()))
                .thenReturn(dummyArtistModel);

        GetArtistModelInteractorImpl interactor = new GetArtistModelInteractorImpl(mExecutor, mMainThread, mArtistRepository,"1",dummyArtistfirst.getId(), mMockedCallback);
        interactor.run();
        Mockito.verify(mArtistRepository).getArtistModel(String.valueOf(1),dummyArtistfirst.getId());
        Mockito.verifyNoMoreInteractions(mArtistRepository);
        Mockito.verify(mMockedCallback).onArtistModelRetrieved(dummyArtistModel);

    }
}
