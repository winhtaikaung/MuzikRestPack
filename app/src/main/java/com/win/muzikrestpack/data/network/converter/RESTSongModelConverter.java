package com.win.muzikrestpack.data.network.converter;

import com.win.muzikrestpack.data.network.model.RESTLinks;
import com.win.muzikrestpack.data.network.model.RESTLinks_;
import com.win.muzikrestpack.data.network.model.RESTMeta;
import com.win.muzikrestpack.data.network.model.RESTSong;
import com.win.muzikrestpack.data.network.model.RESTSongModel;
import com.win.muzikrestpack.data.network.model.RESTSongs;
import com.win.muzikrestpack.data.network.model.RESTSongsAlbum;
import com.win.muzikrestpack.data.network.model.RESTSongsArtist;
import com.win.muzikrestpack.domain.model.Links;
import com.win.muzikrestpack.domain.model.Links_;
import com.win.muzikrestpack.domain.model.Meta;
import com.win.muzikrestpack.domain.model.Song;
import com.win.muzikrestpack.domain.model.SongModel;
import com.win.muzikrestpack.domain.model.Songs;
import com.win.muzikrestpack.domain.model.SongsAlbum;
import com.win.muzikrestpack.domain.model.SongsArtist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win on 3/24/17.
 */

public class RESTSongModelConverter {

    public SongModel convertToSongModel(RESTSongModel model) {


        List<Song> songList = convertToSongList(model.getRESTSongs());
        Links_ links_ = convertToLinks_(model.getLinks());
        Meta meta = convertToMeta(model.getRESTMeta());


        SongModel artistModel = new SongModel(songList, links_, meta);

        return artistModel;

    }

    public List<Song> convertToSongList(List<RESTSong> restSongList) {
        List<Song> songList = new ArrayList<>();
        for (RESTSong restSong : restSongList) {
            songList.add(convertToSong(restSong));
        }
        return songList;
    }

    public Song convertToSong(RESTSong restSong) {
        Song song = new Song(restSong.getId(), restSong.getTitle(), restSong.getHref(), convertToLinks(restSong.getRESTLinks()));
        return song;
    }

    public Links_ convertToLinks_(RESTLinks_ restLinks_) {
        Links_ links_ = new Links_(convertToSongsArtist(restLinks_.getRESTSongsArtist()), convertToSongsAlbum(restLinks_.getRESTSongsAlbum()));
        return links_;
    }

    public SongsArtist convertToSongsArtist(RESTSongsArtist restSongsArtist) {
        SongsArtist songsArtist = new SongsArtist(restSongsArtist.getHref(), restSongsArtist.getType());
        return songsArtist;
    }

    public SongsAlbum convertToSongsAlbum(RESTSongsAlbum restSongsAlbum) {
        SongsAlbum songsAlbum = new SongsAlbum(restSongsAlbum.getHref(), restSongsAlbum.getType());
        return songsAlbum;
    }

    public Links convertToLinks(RESTLinks restLinks) {
        Links links = new Links(restLinks.getArtist(), restLinks.getAlbum());

        return links;
    }

    public Meta convertToMeta(RESTMeta restMeta) {
        Meta meta = new Meta(convertToSongs(restMeta.getSongs()));
        return meta;
    }

    public Songs convertToSongs(RESTSongs restSongs) {
        Songs songs = new Songs(restSongs.getPage(),
                restSongs.getPageSize(),
                restSongs.getCount(),
                restSongs.getInclude(),
                restSongs.getPageCount(),
                restSongs.getPreviousPage(),
                restSongs.getNextPage(),
                restSongs.getPreviousHref(),
                restSongs.getNextHref());
        return songs;
    }
}
