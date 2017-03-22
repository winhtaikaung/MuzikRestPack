package com.win.muzikrestpack.data.repositories.datasource;

/**
 * Created by win on 3/22/17.
 */

public class ArtistDataStoreFactory {

    public ArtistDataStoreFactory() {

    }

    public ArtistDataStore create() {
        return new ArtistCloudDataStore();
    }

}
