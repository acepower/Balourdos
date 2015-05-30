package com.balourdos.IntentServices;

import android.app.IntentService;
import android.content.Intent;
import com.balourdos.BalourdosContainer;
import com.google.android.gms.common.api.GoogleApiClient;

public class OnLoadServiceIntent extends IntentService {
    private GoogleApiClient client;

    public OnLoadServiceIntent(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) { }

    @Override
    public void onCreate() {
        this.client = BalourdosContainer.getGoogleClient();
        super.onCreate();
    }

}
