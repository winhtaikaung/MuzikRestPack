package com.win.muzikrestpack.presentation.ui.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.win.muzikrestpack.R;
import com.win.muzikrestpack.domain.model.Artist;
import com.win.muzikrestpack.domain.model.Song;
import com.win.muzikrestpack.presentation.ui.base.SectionView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by win on 3/26/17.
 */

public class ArtistDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<SectionView> mSectionView;
    Context mContext;

    public ArtistDetailAdapter(List<SectionView> sectionViewList) {
        mSectionView = sectionViewList;
    }

    public void setArtistDetail(List<SectionView> sectionViewList){
        mSectionView = sectionViewList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutRes = 0;
        mContext = parent.getContext();

        if (viewType == 0) {
            layoutRes = R.layout.item_artist_detail_header;
            View artistHeaderView = LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false);
            return new ArtistHeaderViewHolder(artistHeaderView);
        } else {
            layoutRes = R.layout.item_artist_detail_songlist;
            View artistSongListView = LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false);
            return new ArtistSongsViewHolder(artistSongListView);
        }


    }

    @Override
    public int getItemViewType(int position) {
        //Define viewtype via data here
        int viewType = 999;
        switch (position) {
            case 0:
                viewType = 0;
                break;
            case 1:
                viewType = 1;
                break;

        }
        return viewType;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)  {


        int viewType = getItemViewType(position);
        if (viewType == 0) {// Artist View Header
            ArtistHeaderViewHolder artistvh = (ArtistHeaderViewHolder) holder;
            Artist artist = (Artist) mSectionView.get(position).getObject();
            artistvh.tvArtistName.setText(artist.getName());
            artistvh.tvArtistWebSite.setText(artist.getWebsite());
            Picasso.with(mContext).load("https://placeimg.com/640/480/" + artist.getName()).fit().into(artistvh.ivProfile);
        } else {
            ArtistSongsViewHolder vh = (ArtistSongsViewHolder) holder;
            LinearLayoutManager manager = new LinearLayoutManager(mContext);
            vh.tvArtistDetailSongListView.setLayoutManager(manager);
            SongListAdapter adapter = new SongListAdapter();
            List mList = (List<Song>) mSectionView.get(position).getObject();
            adapter.setSongList((List<Song>) mList);
            vh.tvArtistDetailSongListView.setAdapter(adapter);
        }

    }



    @Override
    public int getItemCount() {
        return mSectionView.size();
    }

    class ArtistHeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvArtistName)
        TextView tvArtistName;

        @BindView(R.id.tvArtistWebsite)
        TextView tvArtistWebSite;

        @BindView(R.id.ivProfile)
        ImageView ivProfile;

        public ArtistHeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    class ArtistSongsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rvArtistDetailViewSongList)
        RecyclerView tvArtistDetailSongListView;

        public ArtistSongsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
