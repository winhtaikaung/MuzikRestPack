package com.win.muzikrestpack.data.network.converter;

import com.win.muzikrestpack.data.network.model.RESTArtist;
import com.win.muzikrestpack.data.network.model.RESTArtistModel;
import com.win.muzikrestpack.data.network.model.RESTArtists;
import com.win.muzikrestpack.data.network.model.RESTArtistsAlbums;
import com.win.muzikrestpack.data.network.model.RESTArtistsSongs;
import com.win.muzikrestpack.data.network.model.RESTLinks;
import com.win.muzikrestpack.data.network.model.RESTMeta;
import com.win.muzikrestpack.domain.model.Artist;
import com.win.muzikrestpack.domain.model.ArtistModel;
import com.win.muzikrestpack.domain.model.Artists;
import com.win.muzikrestpack.domain.model.ArtistsAlbums;
import com.win.muzikrestpack.domain.model.ArtistsSongs;
import com.win.muzikrestpack.domain.model.Links;
import com.win.muzikrestpack.domain.model.Meta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win on 3/22/17.
 * This Class is responsible to parse the JSON Model to Pure Model Objects
 */

public class RESTArtistModelConverter {

    public ArtistModel convertToArtistModel(RESTArtistModel model) {


        List<Artist> artistList = convertToArtistList(model.getArtists());
        Links links = convertToLinks(model.getLinks());
        Meta meta = convertToMeta(model.getMeta());


        ArtistModel artistModel = new ArtistModel(artistList, links, meta);

        return artistModel;

    }

    public List<Artist> convertToArtistList(List<RESTArtist> restArtistList) {
        List<Artist> artistList = new ArrayList<>();
        for (RESTArtist artist : restArtistList) {
            artistList.add(convertToArtist(artist));
        }

        return artistList;

    }

    public Artist convertToArtist(RESTArtist restArtist) {
        Artist artist = new Artist(restArtist.getId(), restArtist.getName(), restArtist.getWebsite(), restArtist.getHref());
        return artist;
    }

    public Links convertToLinks(RESTLinks restLinks) {
        Links link = new Links(convertToArtistAlbums(restLinks.getArtistsAlbums()), convertToArtistsSongs(restLinks.getArtistsSongs()));
        return link;
    }

    public ArtistsSongs convertToArtistsSongs(RESTArtistsSongs restArtistsSongs) {
        ArtistsSongs artistsSongs = new ArtistsSongs(restArtistsSongs.getHref(), restArtistsSongs.getType());
        return artistsSongs;

    }

    public ArtistsAlbums convertToArtistAlbums(RESTArtistsAlbums restArtistsAlbums) {
        ArtistsAlbums artistsAlbums = new ArtistsAlbums(restArtistsAlbums.getHref(), restArtistsAlbums.getType());
        return artistsAlbums;
    }

    public Meta convertToMeta(RESTMeta restMeta) {
        Meta meta = new Meta(convertToArtists(restMeta.getArtists()));
        return meta;
    }

    public Artists convertToArtists(RESTArtists restArtists) {
        Artists artists = new Artists(restArtists.getPage(),
                restArtists.getPageSize(),
                restArtists.getInclude(),
                restArtists.getPageCount(),
                restArtists.getPreviousPage(), restArtists.getNextPage(), restArtists.getNextHref(), restArtists.getPreviousHref());
        return artists;
    }

}
