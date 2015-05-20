package com.balourdos.Controllers;

import com.balourdos.BalourdosApplication;
import com.balourdos.Models.GPSTracker;
import com.balourdos.Models.GoogleLocation;

public class BaseController {
    private GPSTracker gps;
    private GoogleLocation fusedLocation;

    public BaseController() {
        this.gps = new GPSTracker(BalourdosApplication.getContext());
        this.fusedLocation = new GoogleLocation();
    }

    public void getCurrentLocation() {
        System.out.println(this.gps.canGetLocation());

        if (this.gps.canGetLocation()) {
            System.out.println("gps"+ this.gps.getLatitude());
            System.out.println("gps"+ this.gps.getLongitude());
        }
    }
    public void getFusedCurrentLocation()
    {
        System.out.println("fused location" + this.fusedLocation.getLastLocation());
    }
}
