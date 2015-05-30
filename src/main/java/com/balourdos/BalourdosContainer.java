package com.balourdos;

import com.balourdos.Modules.DaggerGoogleComponent;
import com.balourdos.Modules.GoogleComponent;
import com.balourdos.Modules.GoogleModule;
import com.google.android.gms.common.api.GoogleApiClient;

public final class BalourdosContainer {
    private static final GoogleComponent googleComponent = DaggerGoogleComponent.builder().googleModule(new GoogleModule()).build();

    public static GoogleApiClient getGoogleClient() {
        return googleComponent.provideGoogleApiClient();
    }
}
