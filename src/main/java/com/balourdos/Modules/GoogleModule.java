package com.balourdos.Modules;

import android.os.Bundle;
import com.balourdos.BalourdosApplication;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Places;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class GoogleModule implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private boolean isConnected = false;
    private boolean isConnectionSuspended = false;
    private boolean isConnectonFailed = false;
    private boolean mResolvingError = false;


    @Provides @Singleton
    GoogleApiClient provideGoogleApiClient() {
        return new GoogleApiClient.Builder(BalourdosApplication.getContext())
            .addApi(LocationServices.API)
            .addApi(Places.GEO_DATA_API)
            .addApi(Places.PLACE_DETECTION_API)
            .addOnConnectionFailedListener(this)
            .addConnectionCallbacks(this)
            .build();
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        this.isConnected = true;
        this.isConnectionSuspended = false;
        this.isConnectonFailed = false;
    }

    @Override
    public void onConnectionSuspended(int cause) {
        this.isConnectionSuspended = true;
        this.isConnected = false;
        System.out.println("Disconnected-suspended");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.isConnected = false;
        this.isConnectonFailed = true;

        if (mResolvingError) {
        } else if (connectionResult.hasResolution()) {
        } else {
            showErrorDialog(connectionResult.getErrorCode());
            mResolvingError = true;
        }

    }

    private void showErrorDialog(int errorCode)
    {

    }
}
