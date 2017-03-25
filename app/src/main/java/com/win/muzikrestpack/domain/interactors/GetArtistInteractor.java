package com.win.muzikrestpack.domain.interactors;

import com.win.muzikrestpack.domain.interactors.base.Interactor;
import com.win.muzikrestpack.domain.model.Artist;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 20/3/17.
 */

public interface GetArtistInteractor extends Interactor{
    interface Callback {
        void onArtistRetrieved(Observable<Artist> artist);
    }
}
