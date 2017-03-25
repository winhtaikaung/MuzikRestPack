package com.win.muzikrestpack.presentation.presenter;

import com.win.muzikrestpack.presentation.view.BaseView;

/**
 * Created by win on 3/25/17.
 */

public interface SongListPresenter {

    interface View extends BaseView {
        void showSongList();

        void onSongItemClick(String songId,int position);
    }

}
