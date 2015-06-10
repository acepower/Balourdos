package com.balourdos;

import com.balourdos.Modules.DaggerGoogleComponent;
import com.balourdos.Modules.GoogleComponent;
import com.balourdos.Modules.GoogleModule;
import com.google.android.gms.common.api.GoogleApiClient;
import org.jdeferred.Promise;

/**
 * Container class to avoid annoying object passing when is not necessary.
 * Should not be used extensively in the cases of the retrieved objects not being singletons, to not lose track of object creation.
 */
public final class BalourdosContainer {
    private static final GoogleComponent googleComponent = DaggerGoogleComponent.builder().googleModule(new GoogleModule()).build();
    private static final GoogleApiClient theClient = googleComponent.provideGoogleApiClient();

    public static Promise<String, Integer, Integer> googleConnect() {
        return googleComponent.provideGoogleConnect();
    }

    public static GoogleApiClient getGoogleClient() {
        return theClient;
    }
}
