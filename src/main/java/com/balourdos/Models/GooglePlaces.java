package com.balourdos.Models;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.*;

public class GooglePlaces extends GoogleConnection {

    private static GooglePlaces INSTANCE = null;

    /**
     * super constructor
     */
    private GooglePlaces(GooglePlayConnect connection){super(connection);}

    /**
     *
     * @return singleton
     */
    public static GooglePlaces getGooglePlacesObj(GooglePlayConnect connection)
    {   if (INSTANCE==null)
        INSTANCE = new GooglePlaces(connection);

        return INSTANCE;
    }


    /**
     *
     * @param filter A PlaceFilter allows you to restrict results to only those places that are of interest to them.
     * @return  an estimate of the place where the device is currently known to be located.
     */
    public PendingResult<PlaceLikelihoodBuffer> getCurrentPlace(PlaceFilter filter)
    {
        return Places.PlaceDetectionApi.getCurrentPlace(this.connection.getClient(), filter);
    }

    /**
     *
     * @param report An indication from the client that the device is currently located at a particular place.
     * @return Report that the device is currently at a particular place.
     */
    public PendingResult<Status> reportDeviceAtPlace(PlaceReport report)
    {
        return Places.PlaceDetectionApi.reportDeviceAtPlace(this.connection.getClient(), report);
    }

    /**
     *
     * @param addPlaceRequest Add a place to Google's Places database.
     * @return a buffer containing the added place
     */
    public  PendingResult<PlaceBuffer> addPlace (AddPlaceRequest addPlaceRequest)
    {
        return Places.GeoDataApi.addPlace(this.connection.getClient(), addPlaceRequest);
    }

    /**
     *
     * @param placeIds strings to construct the places
     * @return Returns the places for the given placeIds.
     */
    public PendingResult<PlaceBuffer> getPlaceById (String... placeIds)
    {
        return Places.GeoDataApi.getPlaceById(this.connection.getClient(), placeIds);
    }
    public GoogleApiClient getClient()
    {
        return this.connection.getClient();
    }


}
