package com.balourdos.Models;

import android.location.Address;
import android.location.Geocoder;
import com.balourdos.BalourdosApplication;

import java.io.IOException;
import java.util.List;

/**
 * Created by kostas on 09-Jun-15.
 */
public final class LocationProcessing {

    private static final Geocoder locProcessor = new Geocoder(BalourdosApplication.getContext());

    /**
     *
     * @param latitude between -90 and 180
     * @param longitude between -180 and 180
     * @param maxResults should be a small number
     * @return list of addresses for the given latitude and longitude
     */
    public static List<Address> getAddresses(double latitude, double longitude, int maxResults)
    {
        if(latitude<=-90 || latitude>=90)
            throw new IllegalArgumentException("Incorrect latitude input");
        if(longitude<=-180 || longitude>=180)
            throw new IllegalArgumentException("Incorrect longitude input");

        try {
            return locProcessor.getFromLocation(latitude,longitude,maxResults);
        } catch (IOException e) {
            return null;
        }
    }


}
