package com.balourdos.Models;

import com.balourdos.Modules.GoogleComponent;
import com.balourdos.Modules.DaggerGoogleComponent;
import com.balourdos.Modules.GoogleModule;

public abstract class GoogleConnection {
    protected final GooglePlayConnect connection;

    /**
     * Creates a new GoogleApiClient to be injected to the GooglePlayConnect class
     */
    protected GoogleConnection() {
        GoogleComponent googleComponent = DaggerGoogleComponent.builder().googleModule(new GoogleModule()).build();
        this.connection = new GooglePlayConnect(googleComponent.provideGoogleApiClient());
    }
}
