package com.balourdos.Models;

import com.google.android.gms.common.api.GoogleApiClient;
import javax.inject.Inject;

class GooglePlayConnect {

    private final GoogleApiClient googleApiClient;

    @Inject
    public GooglePlayConnect(GoogleApiClient googleApiClient) {
        // As we inject GoogleApiClient - this can now be mocked so we can test every outcome in this class
        this.googleApiClient = googleApiClient;

        try {
            this.googleApiClient.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
