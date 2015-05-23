package com.balourdos.Models;


import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by kostas on 23-May-15.
 */
public class GooglePlaces {

    private final GooglePlayConnect connection;
    private final GoogleApiClient client;
    private static final GooglePlaces INSTANCE = new GooglePlaces();

    private GooglePlaces(){
        this.connection = GooglePlayConnect.getGooglePlayConnection();
        this.client = connection.getConnection();
    }

    /**
     *
     * @return singleton
     */
    public GooglePlaces getInstance() {return INSTANCE;}
}
