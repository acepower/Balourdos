package com.balourdos.Controllers;

import com.balourdos.BalourdosApplication;
import com.balourdos.Models.GoogleLocation;

public class BaseController {
    private GoogleLocation fusedLocation;

    public BaseController() {
        this.fusedLocation = GoogleLocation.getLocationObject();
    }


    public void getPayload() {
        System.out.println("fused location" + this.fusedLocation.getLastLocation());
    }
}
