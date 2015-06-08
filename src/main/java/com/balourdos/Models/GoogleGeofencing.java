package com.balourdos.Models;


import android.location.Location;
import com.balourdos.Constants;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.Geofence;

import javax.inject.Inject;
/**
 * Created by kostas on 08-Jun-15.
 */
public class GoogleGeofencing {

    private static GoogleGeofencing INSTANCE = null;
    private Location userLocation;
    private final GoogleApiClient googleClient;
    private Geofence userGeofence;


    private GoogleGeofencing(Location initialLocation, GoogleApiClient client)
    {
        if(initialLocation==null) {
            throw new NullPointerException("Cannot create geofence without user location");
        }
        else{
            this.userLocation=initialLocation;
        }
        if(client==null) {
            throw new NullPointerException("Cannot create geofence without api client");
        }
        else {
            this.googleClient=client;
        }

        this.setUpGeofence();

    }

    /**
     *
     * @param initialLocation the phone's initial location
     * @param client a stable google client
     * @return geofencing object
     */
    @Inject
    public static GoogleGeofencing getGeofencer(Location initialLocation, GoogleApiClient client)
    {
        if (INSTANCE==null)
            INSTANCE = new GoogleGeofencing(initialLocation,client);

            return INSTANCE;
    }

    /**
     * creates the perimeter of interest, given a mobile location that is valid
     */
    private void setUpGeofence()
    {
        this.userGeofence= new Geofence.Builder()
            .setRequestId("Test")
            .setCircularRegion(this.userLocation.getLatitude(),this.userLocation.getLongitude(), Constants.GEOFENCE_PERIMETER)
            .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT)
            .build();
    }

}
