package com.balourdos.Models;

import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.*;

public class GoogleLocation extends GoogleConnection {

    /**
     * Uses the FusedLocationApi method getLastLocation
     * @return the best most recent location currently available.
     */
    public Location getLastLocation()
    {
        if (this.client.isConnected()) {
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
        if (this.client.isConnected()) {
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
        if (this.client.isConnected()) {
            return LocationServices.FusedLocationApi.removeLocationUpdates(this.client, listener);
        }

        return null;
    }

}
