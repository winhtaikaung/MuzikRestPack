package com.win.muzikrestpack.presentation.presenters;

import com.win.muzikrestpack.domain.model.Artist;
import com.win.muzikrestpack.domain.model.Song;
import com.win.muzikrestpack.presentation.view.BaseView;

import java.util.List;

/**
 * Created by win on 3/26/17.
 */

public interface ArtistDetailPresenter {
    void getArtistModel(String id);

    void getSongModelByArtistId(String page, String artistId);

    interface View extends BaseView {
        void onArtistModelRetrieved(Artist artist);

        void onSongListRetrieved(List<Song> songList);
    }
}

