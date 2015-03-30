package com.balourdos.Activities;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import android.app.Activity;
import com.google.android.gms.drive.Drive;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.location.*;


/**
 * Created by kostas on 29-Mar-15.
 */
public class GoogleMapsConnection extends Activity {

    private static final GoogleMapsConnection CONNECTION = new GoogleMapsConnection();
    private GoogleApiClient myGoogleClient;

    private GoogleMapsConnection(){}

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        myGoogleClient = new GoogleApiClient.Builder(this)
            .addApi(ActivityRecognition.API)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .build();

    }

    public GoogleMapsConnection getInstance()
    {
        return CONNECTION;
    }
}
