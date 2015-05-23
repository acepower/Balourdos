package com.balourdos.Models;

import android.location.Location;
import com.balourdos.BalourdosApplication;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.*;

public class GoogleLocation {

    private final GooglePlayConnect connection;
    private final GoogleApiClient client;
    private static final GoogleLocation INSTANCE = new GoogleLocation();

    private GoogleLocation() {
       this.connection = new GooglePlayConnect(BalourdosApplication.getContext(), LocationServices.API);
       this.client = connection.getConnection();
    }

    /**
     *
     * @return singleton
     */
    public static GoogleLocation getInstance() {return INSTANCE;}

    /**
     * Uses the FusedLocationApi method getLastLocation
     * @return the best most recent location currently available.
     */
    public Location getLastLocation()
    {
        if (this.connection.isConnected()) {
            try {
                return LocationServices.FusedLocationApi.getLastLocation(this.client);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException("Not connected to google play");
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
        if (this.connection.isConnected()) {
            try {
                return LocationServices.FusedLocationApi.requestLocationUpdates(this.client, request, listener);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public PendingResult<Status> RemoveLocationUpdates(LocationListener listener)
    {
        if (this.connection.isConnected()) {
            return LocationServices.FusedLocationApi.removeLocationUpdates(this.client, listener);
        }

        return null;
    }

}
