package com.balourdos.Models;

import com.balourdos.Modules.GoogleComponent;
import com.balourdos.Modules.DaggerGoogleComponent;
import com.balourdos.Modules.GoogleModule;
import com.google.android.gms.common.api.GoogleApiClient;

public abstract class GoogleConnection {
    protected final GooglePlayConnect connection;

    /**
     * Creates a new GoogleApiClient to be injected to the GooglePlayConnect class
     */
    protected GoogleConnection(GooglePlayConnect connection ) {

        if(connection != null)
            this.connection = connection;
        else
            throw new NullPointerException("connection cannot be null");
    }
}
