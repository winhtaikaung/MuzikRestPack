package com.win.muzikrestpack.domain.interactors;

import com.win.muzikrestpack.domain.interactors.base.Interactor;
import com.win.muzikrestpack.domain.model.ArtistModel;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 20/3/17.
 */

public interface GetAllArtistModelInteractor extends Interactor {
    interface Callback {
        void onArtistModelRetrieved(Observable<ArtistModel> artistModel);

    }
}
