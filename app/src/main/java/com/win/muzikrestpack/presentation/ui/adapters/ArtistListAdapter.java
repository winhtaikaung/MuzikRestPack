package com.win.muzikrestpack.presentation.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
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
    List<Artist> mArtistList;


    public ArtistListAdapter() {
        mArtistList = new ArrayList<>();
    }

    public void setmArtistList(List<Artist> mArtistList) {
        this.mArtistList = mArtistList;
        notifyDataSetChanged();
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View view = LayoutInflater.from(mContext).inflate(R.layout.artist_item_view, parent, false);
        return new ViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        //Do Data Processing here
        ViewHolder vh = (ViewHolder) holder;
        if (vh != null) {
            if (mArtistList.get(position) != null) {
                Artist artist = mArtistList.get(position);
                Picasso.with(mContext).load("https://placeimg.com/640/480/" + artist.getName()).into(vh.ivProfile);
                vh.mText.setText(artist.getName());
                vh.tvArtistWebsite.setText(artist.getWebsite());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mArtistList != null ? mArtistList.size() : 0;
    }

    class ViewHolder extends BaseViewHolder {
        @BindView(R.id.tvArtistName)
        TextView mText;

        @BindView(R.id.ivProfile)
        ImageView ivProfile;

        @BindView(R.id.tvArtistWebsite)
        TextView tvArtistWebsite;

        public ViewHolder(View itemView, ArtistListAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mAdapter = adapter;
        }


    }


}
