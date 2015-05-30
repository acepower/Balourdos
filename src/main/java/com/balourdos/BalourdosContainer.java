package com.balourdos;

import com.balourdos.Modules.DaggerGoogleComponent;
import com.balourdos.Modules.GoogleComponent;
import com.balourdos.Modules.GoogleModule;
import com.google.android.gms.common.api.GoogleApiClient;
import org.jdeferred.Promise;

public final class BalourdosContainer {
    private static final GoogleComponent googleComponent = DaggerGoogleComponent.builder().googleModule(new GoogleModule()).build();

    public static Promise googleConnect() {
        return googleComponent.provideGoogleConnect();
    }

    public static GoogleApiClient getGoogleClient() {
        return googleComponent.provideGoogleApiClient();
    }
}
