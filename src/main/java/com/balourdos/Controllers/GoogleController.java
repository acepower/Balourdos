package com.balourdos.Controllers;

import com.balourdos.Models.GoogleLocation;
import com.balourdos.Models.GooglePlaces;
import com.google.android.gms.common.api.GoogleApiClient;

public class GoogleController {
    private GoogleLocation fusedLocation;
    private GooglePlaces googlePlaces;

    public GoogleController(GoogleApiClient client) {
        this.fusedLocation = GoogleLocation.getLocationObj(client);
        this.googlePlaces = GooglePlaces.getGooglePlacesObj(client);
    }

    public void getPayload() {
        System.out.println("fused location" + this.fusedLocation.getLastLocation());
        System.out.println(this.fusedLocation.getClient().hashCode());
        System.out.println(this.googlePlaces.getClient().hashCode());
    }
}
