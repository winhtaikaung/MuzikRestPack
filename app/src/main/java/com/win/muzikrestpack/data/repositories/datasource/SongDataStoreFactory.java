package com.win.muzikrestpack.data.repositories.datasource;

/**
 * Created by win on 3/22/17.
 */

public class SongDataStoreFactory {

    public SongDataStoreFactory() {

    }

    public SongDataStore create() {
        return new SongCloudDataStore();
    }

}
