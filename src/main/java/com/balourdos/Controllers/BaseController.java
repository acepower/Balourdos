package com.balourdos.Controllers;


import com.balourdos.Models.GoogleLocation;
import com.balourdos.Models.GooglePlaces;
import com.balourdos.Modules.DaggerGoogleComponent;
import com.balourdos.Modules.GoogleComponent;
import com.balourdos.Modules.GoogleModule;
import com.balourdos.Models.GooglePlayConnect_Factory;

public class BaseController {
    private GoogleLocation fusedLocation;
    private GooglePlaces googlePlaces;

    public BaseController() {
        GoogleComponent googleComponent = DaggerGoogleComponent.builder().googleModule(new GoogleModule()).build();
        GooglePlayConnect_Factory um = new GooglePlayConnect_Factory(googleComponent.provideGoogleApiClient());
        this.fusedLocation = GoogleLocation.getLocationObj();
        this.googlePlaces = GooglePlaces.getGooglePlacesObj();


    }


    public void getPayload() {
        System.out.println("fused location" + this.fusedLocation.getLastLocation());

    }
}
