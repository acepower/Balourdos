package com.balourdos.Models;



import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.*;


public class GoogleLocation implements GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener {


    private final GoogleApiClient CONNECTION;
    private boolean isConnected = false;
    private boolean isConnectionSuspended = false;
    private boolean isConnectonFailed = false;

    public GoogleLocation(android.content.Context applicationContext) {
        this.CONNECTION = new GoogleApiClient.Builder(applicationContext)
                .addApi(LocationServices.API)
                .addOnConnectionFailedListener(this)
                .addConnectionCallbacks(this)
                .build();

        try
        {
            this.CONNECTION.connect();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Connected to Google Play services! The good stuff happens there
     * @param connectionHint
     */
    public void onConnected(Bundle connectionHint) {

        this.isConnected = true;
        this.isConnectionSuspended = false;
        this.isConnectonFailed = false;
        System.out.println("Connected biatch");

    }
    /**
     * The connection has been interrupted. Google docs suggest disabling any UI components that
     * depend on Google APIs until onConnected() is called
     * @param cause
     */
    public void onConnectionSuspended(int cause) {

        this.isConnectionSuspended = true;
        this.isConnected = false;
        System.out.println("Disconnected-suspended");
    }

    /**
     * This callback is handling errors that may occur while attempting to connect with Google.
     * @param connectionResult
     */
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.isConnected= false;
        this.isConnectonFailed = true;

        // to do
        System.out.println(connectionResult.getErrorCode());
        System.out.println("Not Connected");

    }
    public void disconnect()
    {
        this.CONNECTION.disconnect();
    }

    //--------------------------------- location services ---------------------------------//

    /**
     * Uses the FusedLocationApi method getLastLocation
     * @return the best most recent location currently available.
     */
    public Location getLastLocation()
    {

        if(this.isConnected) {
            try {
                return LocationServices.FusedLocationApi.getLastLocation(this.CONNECTION);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        if(this.isConnected) {
            try {
                return LocationServices.FusedLocationApi.requestLocationUpdates(this.CONNECTION, request, listener);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public PendingResult<Status> RemoveLocationUpdates(LocationListener listener)
    {
        if(this.isConnected)
        return LocationServices.FusedLocationApi.removeLocationUpdates(this.CONNECTION, listener);

        return null;
    }
}
