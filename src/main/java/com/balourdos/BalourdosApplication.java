package com.balourdos;

import android.app.Application;
import com.balourdos.Models.GPSTracker;

/**
 * Dependency injection container so components can be mock tested
 */
public class BalourdosApplication extends Application {
    public BalourdosApplication() { }

    public GPSTracker gps = new GPSTracker(this);
}
