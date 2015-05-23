package com.balourdos.Models;

import com.balourdos.BalourdosApplication;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;

/**
 * Created by kostas on 23-May-15.
 */
public class GooglePlaces {

    private final GooglePlayConnect connection;
    private final GoogleApiClient client;
    private static final GooglePlaces INSTANCE = new GooglePlaces();

    private GooglePlaces(){
        this.connection = new GooglePlayConnect(BalourdosApplication.getContext(), Places.GEO_DATA_API);
        this.client = connection.getConnection();
    }

    /**
     *
     * @return singleton
     */
    public GooglePlaces getInstance() {return INSTANCE;}
}
