package com.balourdos.Models;

import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.*;

import javax.inject.Inject;

public class GoogleLocation{

    private static GoogleLocation INSTANCE = null;
    private final GoogleApiClient client;
    /**
     * Calling the super constructor
     */
    private GoogleLocation(GoogleApiClient client) {
        if(client != null) {
            this.client = client;
        }
        else {
            throw new NullPointerException("client cannot be null");
        }
    }

    /**
     *
     * @return singleton
     */
    @Inject
    public static GoogleLocation getLocationObj(GoogleApiClient client)
    {   if (INSTANCE == null) {
            INSTANCE = new GoogleLocation(client);
        }

        return INSTANCE;
    }
    /**
     * Uses the FusedLocationApi method getLastLocation
     * @return the best most recent location currently available or null.
     */
    public Location getLastLocation()
    {
        try{return LocationServices.FusedLocationApi.getLastLocation(this.client);}
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
        try {return LocationServices.FusedLocationApi.requestLocationUpdates(this.client, request, listener);}
        catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }

    public PendingResult<Status> RemoveLocationUpdates(LocationListener listener)
    {
        try{return LocationServices.FusedLocationApi.removeLocationUpdates(this.client, listener);}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public GoogleApiClient getClient()
    {
        return this.client;
    }

}
