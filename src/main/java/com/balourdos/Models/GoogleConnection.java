package com.balourdos.Models;


import com.google.android.gms.common.api.GoogleApiClient;



public abstract class GoogleConnection {
    protected final GoogleApiClient client;

    /**
     * Creates a new GoogleApiClient to be injected to the GooglePlayConnect class
     */
    protected GoogleConnection(GoogleApiClient client) {
        if(client != null) {
            this.client = client;
        }
        else {
            throw new NullPointerException("client cannot be null");
        }
    }
}
