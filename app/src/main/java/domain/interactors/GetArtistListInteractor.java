package domain.interactors;

import java.util.List;

import io.reactivex.Observable;
import model.Artist;

/**
 * Created by winhtaikaung on 20/3/17.
 */

public interface GetArtistListInteractor {
    interface Callback {
        void onArtistListRetrieved(Observable<List<Artist>> flightList);
    }
}
