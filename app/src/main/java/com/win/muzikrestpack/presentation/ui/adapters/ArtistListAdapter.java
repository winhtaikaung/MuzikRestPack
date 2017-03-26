package com.win.muzikrestpack.presentation.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.win.muzikrestpack.R;
import com.win.muzikrestpack.domain.model.Artist;
import com.win.muzikrestpack.presentation.ui.base.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by win on 3/25/17.
 */

public class ArtistListAdapter extends BaseAdapter<BaseAdapter.BaseViewHolder> {

    Context mContext;
    List<Artist> artistList;


    public ArtistListAdapter() {
        artistList = new ArrayList<>();
    }

    public void setSongList(List<Artist> songList) {
        artistList = songList;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View view = LayoutInflater.from(mContext).inflate(R.layout.artist_item_view, parent, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        //Do Data Processing here
    }

    @Override
    public int getItemCount() {
        return artistList != null ? artistList.size() : 0;
    }

    class ViewHolder extends BaseViewHolder {
        @BindView(R.id.tvArtistName)
        TextView mText;

        public ViewHolder(View itemView, ArtistListAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }
    }


}
