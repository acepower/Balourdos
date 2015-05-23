package com.balourdos.Models;

import com.balourdos.Modules.GoogleComponent;
import com.balourdos.Modules.DaggerGoogleComponent;
import com.balourdos.Modules.GoogleModule;
import com.google.android.gms.common.api.GoogleApiClient;

public class GoogleConnection {
    protected GooglePlayConnect connection;
    protected GoogleApiClient client;

    public GoogleConnection() {
        GoogleComponent googleComponent = DaggerGoogleComponent.builder().googleModule(new GoogleModule()).build();
        this.client = googleComponent.provideGoogleApiClient();
        this.connection = new GooglePlayConnect(this.client);
    }
}
