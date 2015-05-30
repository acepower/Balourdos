package com.balourdos.Modules;

import com.google.android.gms.common.api.GoogleApiClient;
import org.jdeferred.Promise;
import javax.inject.Singleton;
import dagger.Component;

@Singleton @Component(modules = {GoogleModule.class})
public interface GoogleComponent {
    GoogleApiClient provideGoogleApiClient();
    Promise<String, Integer, Integer> provideGoogleConnect();
}
