package com.balourdos.Models;

import android.location.Location;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.*;

public class GoogleLocation extends GoogleConnection {

    private static final GoogleLocation INSTANCE = new GoogleLocation();
    /**
     * Calling the super constructor
     */
    private GoogleLocation() {super();}

    /**
     *
     * @return singleton
     */
    public static GoogleLocation getLocationObject() {return INSTANCE;}
    /**
     * Uses the FusedLocationApi method getLastLocation
     * @return the best most recent location currently available or null.
     */
    public Location getLastLocation()
    {
        try{return LocationServices.FusedLocationApi.getLastLocation(this.connection.getClient());}
        catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }

    /**
     * Requests location updates, mostly used in foreground cases (while being connected to the Google API client
     * Any previous LocationRequests registered on this LocationListener will be replaced.
     * @param listener The listener for the location updates
     * @param request The location request for the updates.
     * @return a PendingResult for the call, check isSuccess() of Status class to determine if it was successful.
     */
    public PendingResult<Status> RequestLocationUpdate(LocationListener listener, LocationRequest request)
    {
        try {return LocationServices.FusedLocationApi.requestLocationUpdates(this.connection.getClient(), request, listener);}
        catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }

    public PendingResult<Status> RemoveLocationUpdates(LocationListener listener)
    {
        try{return LocationServices.FusedLocationApi.removeLocationUpdates(this.connection.getClient(), listener);}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
