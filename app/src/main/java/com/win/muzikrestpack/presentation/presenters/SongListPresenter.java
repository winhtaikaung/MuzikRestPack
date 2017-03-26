package com.win.muzikrestpack.presentation.presenters;

import android.content.Context;

import com.win.muzikrestpack.domain.model.Song;
import com.win.muzikrestpack.presentation.view.BaseView;

import java.util.List;

/**
 * Created by win on 3/26/17.
 */

public interface SongListPresenter {
    interface View extends BaseView {

        void onAllSongModelRetrieved(List<Song> songModelObservable);
    }

    void getAllSongsModel(String page, String pageSize);

    boolean doCheckDataConnection(Context context);

}
