package com.balourdos.Modules;

import android.os.Bundle;
import com.balourdos.BalourdosApplication;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Places;
import dagger.Module;
import dagger.Provides;
import org.jdeferred.Deferred;
import org.jdeferred.Promise;
import org.jdeferred.impl.DeferredObject;
import javax.inject.Singleton;

@Module
public class GoogleModule implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private boolean isConnected = false;
    private boolean isConnectionSuspended = false;
    private boolean isConnectonFailed = false;
    private boolean resolvingError = false;
    private Deferred deferred = new DeferredObject();
    private Promise promise = deferred.promise();

    @Provides @Singleton
    public GoogleApiClient provideGoogleApiClient() {
        return new GoogleApiClient.Builder(BalourdosApplication.getContext())
            .addApi(LocationServices.API)
            .addApi(Places.GEO_DATA_API)
            .addApi(Places.PLACE_DETECTION_API)
            .addOnConnectionFailedListener(this)
            .addConnectionCallbacks(this)
            .build();
    }

    @Provides @Singleton
    public Promise provideGoogleConnect() {
        this.provideGoogleApiClient().connect();
        return this.promise;
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        this.isConnected = true;
        this.isConnectionSuspended = false;
        this.isConnectonFailed = false;
        this.deferred.resolve("done");
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

        if (resolvingError) {
        } else if (connectionResult.hasResolution()) {
        } else {
            this.deferred.reject(connectionResult.getErrorCode());
            resolvingError = true;
        }
    }

    private void showErrorDialog(int errorCode)
    {

    }
}
