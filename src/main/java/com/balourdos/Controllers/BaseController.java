package com.balourdos.Controllers;

import android.app.Application;
import com.balourdos.BalourdosApplication;

public class BaseController {
    private BalourdosApplication app;

    public BaseController(BalourdosApplication app) {
        this.app = app;
    }

    public void getCurrentLocation() {
        System.out.println(this.app.gps.canGetLocation());

        if (this.app.gps.canGetLocation()) {
            System.out.println(this.app.gps.getLatitude());
            System.out.println(this.app.gps.getLongitude());
        }
    }
}
