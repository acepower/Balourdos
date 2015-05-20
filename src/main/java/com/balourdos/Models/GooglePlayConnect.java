package com.balourdos.Models;





import android.os.Bundle;
import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;


class GooglePlayConnect implements GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener {


    private final GoogleApiClient CONNECTION;
    private boolean isConnected = false;
    private boolean isConnectionSuspended = false;
    private boolean isConnectonFailed = false;
    private boolean mResolvingError = false;

    public GooglePlayConnect(Context applicationContext, Api api) {
        if(api==null || applicationContext==null)
            throw new NullPointerException("API or applicationContext cannot be null");

        this.CONNECTION = new GoogleApiClient.Builder(applicationContext)
            //don't like this, need to research.
            .addApi(api)
            .addOnConnectionFailedListener(this)
            .addConnectionCallbacks(this)
            .build();

        try {
            this.CONNECTION.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Connected to Google Play services! The good stuff happens there
     *
     * @param connectionHint
     */
    public void onConnected(Bundle connectionHint) {

        this.isConnected = true;
        this.isConnectionSuspended = false;
        this.isConnectonFailed = false;

    }

    /**
     * The connection has been interrupted. Google docs suggest disabling any UI components that
     * depend on Google APIs until onConnected() is called
     *
     * @param cause
     */
    public void onConnectionSuspended(int cause) {

        this.isConnectionSuspended = true;
        this.isConnected = false;
        System.out.println("Disconnected-suspended");
    }

    /**
     * This callback is handling errors that may occur while attempting to connect with Google.
     *
     * @param connectionResult
     */
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.isConnected = false;
        this.isConnectonFailed = true;

        if (mResolvingError) {
            // Already attempting to resolve an error.
            return;
        } else if (connectionResult.hasResolution()) {
//            try {
//                mResolvingError = true;
//                launch a new activity to solve the error (activity is not defined yet)
//                connectionResult.startResolutionForResult(this, REQUEST_RESOLVE_ERROR);
//            } catch (IntentSender.SendIntentException e) {
//                // There was an error with the resolution intent. Try again.
//              this.CONNECTION.connect();
//            }
        } else {
            // Show dialog using GooglePlayServicesUtil.getErrorDialog()
            showErrorDialog(connectionResult.getErrorCode());
            mResolvingError = true;
        }

    }

    /**
     * create error dialog
     * @param errorCode
     */
    private void showErrorDialog(int errorCode)
    {

    }

    public void disconnect() {
        this.CONNECTION.disconnect();
    }

    /**
     *
     * @return if we are connected to google play services
     */
    public boolean isConnected() {return this.isConnected;}

    /**
     *
     * @return the connection to the API or null
     */
    public GoogleApiClient getConnection()
    {
        return this.CONNECTION;
    }




}
