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

/**
 * This class creates a google API client connection and provides it to the application components.
 * Also provides promises to help classes realise the state of the connectionto the google api client
 */
@Module
public class GoogleModule implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private boolean isConnected = false;
    private boolean isConnectionSuspended = false;
    private boolean isConnectonFailed = false;
    private boolean resolvingError = false;
    private Deferred<String, Integer, Integer> deferred = new DeferredObject<String, Integer, Integer>();
    private Promise<String, Integer, Integer> promise = deferred.promise();

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

    /**
     *
     * @return singleton promise if we're connected to the client
     */
    @Provides @Singleton
    public Promise<String, Integer, Integer> provideGoogleConnect() {
        this.provideGoogleApiClient().connect();
        return this.promise;
    }

    /**
     *
     * @param connectionHint good stuff goes there
     */
    @Override
    public void onConnected(Bundle connectionHint) {
        this.isConnected = true;
        this.isConnectionSuspended = false;
        this.isConnectonFailed = false;
        this.deferred.resolve("done");
    }

    /**
     *
     * @param cause the cause of the suspension of connection
     */
    @Override
    public void onConnectionSuspended(int cause) {
        this.isConnectionSuspended = true;
        this.isConnected = false;
        System.out.println("Disconnected-suspended");
    }

    /**
     *
     * @param connectionResult result of connection failure
     */
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
