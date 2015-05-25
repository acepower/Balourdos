package com.balourdos.Models;


import com.google.android.gms.common.api.GoogleApiClient;

import javax.inject.Inject;

public abstract class GoogleConnection {
    protected final GoogleApiClient client;

    /**
     * Creates a new GoogleApiClient to be injected to the GooglePlayConnect class
     */
    @Inject
    protected GoogleConnection(GoogleApiClient client) {
        this.client = client;
    }
}
