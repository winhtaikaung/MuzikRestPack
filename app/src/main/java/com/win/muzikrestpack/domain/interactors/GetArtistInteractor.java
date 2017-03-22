package com.win.muzikrestpack.domain.interactors;

import io.reactivex.Observable;
import com.win.muzikrestpack.domain.model.Artist;

/**
 * Created by winhtaikaung on 20/3/17.
 */

public interface GetArtistInteractor {
    interface Callback {
        void onArtistRetrieved(Observable<Artist> artist);
    }
}
