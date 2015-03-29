package com.balourdos.Models;
import com.google.android.maps.*;

/**
 * Created by kostas on 29-Mar-15.
 */
public class GoogleMapsConnection {

    private static final GoogleMapsConnection CONNECTION = new GoogleMapsConnection();

    private GoogleMapsConnection(){

    }

    public GoogleMapsConnection getInstance()
    {
        return CONNECTION;
    }
}
