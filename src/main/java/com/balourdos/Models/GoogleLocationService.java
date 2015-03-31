package com.balourdos.Models;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.*;


public class GoogleLocationService extends IntentService implements GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener {

    private final GoogleApiClient CONNECTION;
    public GoogleLocationService() {
        super("Connecting to Google API location services");

        this.CONNECTION = new GoogleApiClient.Builder(this)
            .addApi(LocationServices.API)
            .addOnConnectionFailedListener(this)
            .addConnectionCallbacks(this)
            .build();


    }
    public GoogleApiClient getLocationConnection()
    {
        return this.CONNECTION;
    }



    @Override
    protected void onHandleIntent(Intent intent) {



    }


    /**
     * Connected to Google Play services! The good stuff happens there
     * @param connectionHint
     */
    public void onConnected(Bundle connectionHint) {

    }

    /**
     * The connection has been interrupted. Google docs suggest disabling any UI components that
     * depend on Google APIs until onConnected() is called
     * @param cause
     */
    public void onConnectionSuspended(int cause) {

    }

    /**
     * This callback is handling errors that may occur while attempting to connect with Google.
     * @param connectionResult
     */
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
