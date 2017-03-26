package com.win.muzikrestpack.domain.interactors;

import com.win.muzikrestpack.domain.model.ArtistModel;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 20/3/17.
 */

public interface GetArtistModelByIdInteractor {
    interface Callback {
        void onArtistModelByIdRetrieved(Observable<ArtistModel> artistModel);

    }
}
