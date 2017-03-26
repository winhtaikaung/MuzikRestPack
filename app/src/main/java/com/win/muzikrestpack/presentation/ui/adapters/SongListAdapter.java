package com.win.muzikrestpack.presentation.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.win.muzikrestpack.R;
import com.win.muzikrestpack.domain.model.Song;
import com.win.muzikrestpack.presentation.ui.base.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by win on 3/25/17.
 */

public class SongListAdapter extends BaseAdapter<BaseAdapter.BaseViewHolder> {

    Context mContext;
    List<Song> mSongList;


    public SongListAdapter() {
        mSongList = new ArrayList<>();
    }

    public void setSongList(List<Song> songList) {
        mSongList = songList;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View view = LayoutInflater.from(mContext).inflate(R.layout.song_item_view, parent, false);
        return new ViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mSongList != null ? mSongList.size() : 0;
    }

    class ViewHolder extends BaseAdapter.BaseViewHolder {
        @BindView(R.id.tvSongName)
        TextView mText;

        public ViewHolder(View itemView, SongListAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }


}
