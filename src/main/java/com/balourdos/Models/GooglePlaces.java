package com.balourdos.Models;




public class GooglePlaces extends GoogleConnection {


    private static final GooglePlaces INSTANCE = new GooglePlaces();

    /**
     * super constructor
     */
    private GooglePlaces(){super();}

    /**
     *
     * @return singleton
     */
    public static GooglePlaces getGooglePlacesObj() {return INSTANCE;}
}
