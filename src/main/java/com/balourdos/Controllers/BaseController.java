package com.balourdos.Controllers;


import android.os.Bundle;
import com.balourdos.Modules.DaggerGoogleComponent;
import com.balourdos.Modules.GoogleComponent;
import com.balourdos.Modules.GoogleModule;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;

public class BaseController {
    private final GoogleApiClient client;

    public BaseController() {
        GoogleComponent googleComponent = DaggerGoogleComponent.builder().googleModule(new GoogleModule()).build();
        this.client = googleComponent.provideGoogleApiClient();

        this.client.registerConnectionCallbacks(new ConnectionCallbacks() {
            private GoogleController googleController;

            @Override
            public void onConnected(Bundle bundle) {
                this.googleController = new GoogleController(client);
                this.googleController.getPayload();
            }

            @Override
            public void onConnectionSuspended(int i) {

            }
        });

        this.client.connect();
    }
}
