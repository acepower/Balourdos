package com.balourdos.Modules;

import com.google.android.gms.common.api.GoogleApiClient;

public final class BalourdosContainer {
    private static final GoogleComponent googleComponent = DaggerGoogleComponent.builder().googleModule(new GoogleModule()).build();

    public static GoogleApiClient getGoogleClient() {
        return googleComponent.provideGoogleApiClient();
    }
}
