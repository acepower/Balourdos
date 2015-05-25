package com.balourdos.Controllers;


import com.balourdos.Models.GoogleLocation;
import com.balourdos.Models.GooglePlaces;
import com.balourdos.Modules.DaggerGoogleComponent;
import com.balourdos.Modules.GoogleComponent;
import com.balourdos.Modules.GoogleModule;

public class BaseController {
    private GoogleLocation fusedLocation;
    private GooglePlaces googlePlaces;

    public BaseController() {
        GoogleComponent googleComponent = DaggerGoogleComponent.builder().googleModule(new GoogleModule()).build();
        this.fusedLocation = GoogleLocation.getLocationObj(googleComponent.provideGoogleApiClient());
        this.googlePlaces = GooglePlaces.getGooglePlacesObj(googleComponent.provideGoogleApiClient());
    }


    public void getPayload() {
        System.out.println("fused location" + this.fusedLocation.getLastLocation());

    }
}
