package domain.interactors.repository;

import java.util.List;

import io.reactivex.Observable;
import model.Artist;

/**
 * Created by winhtaikaung on 20/3/17.
 */

public interface ArtistRepository {

    Observable<Artist> getArtist();

    Observable<List<Artist>> getArtists();
}
