package com.win.muzikrestpack.presentation.presenters;

import android.content.Context;

import com.win.muzikrestpack.domain.model.Artist;
import com.win.muzikrestpack.presentation.view.BaseView;

import java.util.List;

/**
 * Created by win on 3/26/17.
 */

public interface ArtistListPresenter {
    void getAllArtistModel(String page, String pageSize);

    boolean doCheckDataConnection(Context context);

    interface View extends BaseView {
        void onArtistModelRetrieved(List<Artist> artistList);
    }
}
