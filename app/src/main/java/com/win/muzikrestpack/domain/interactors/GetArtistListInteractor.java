package com.win.muzikrestpack.domain.interactors;

import com.win.muzikrestpack.domain.interactors.base.Interactor;
import com.win.muzikrestpack.domain.model.Artist;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 20/3/17.
 */

public interface GetArtistListInteractor extends Interactor {
    interface Callback {
        void onArtistListRetrieved(Observable<List<Artist>> flightList);
    }
}
