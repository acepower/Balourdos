package com.balourdos.Controllers;

import com.balourdos.BalourdosApplication;
import com.balourdos.Models.GPSTracker;
import com.balourdos.Models.GoogleLocation;

public class BaseController {
    private GoogleLocation fusedLocation;

    public BaseController() {
        this.fusedLocation = new GoogleLocation();
    }
    
    public void getFusedCurrentLocation()
    {
        System.out.println("fused location" + this.fusedLocation.getLastLocation());
    }
}
