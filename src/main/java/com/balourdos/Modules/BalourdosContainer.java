package com.balourdos.Modules;

import com.google.android.gms.common.api.GoogleApiClient;

public final class BalourdosContainer {
    private static GoogleComponent googleComponent;

    public static void BalourdosContainer() {
        googleComponent = DaggerGoogleComponent.builder().googleModule(new GoogleModule()).build();
    }

    public static GoogleApiClient getGoogleClient() {
        return googleComponent.provideGoogleApiClient();
    }
}
