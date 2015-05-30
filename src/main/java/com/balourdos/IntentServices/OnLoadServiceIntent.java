package com.balourdos.IntentServices;

import android.app.IntentService;
import android.content.Intent;
import com.balourdos.BalourdosContainer;
import com.google.android.gms.common.api.GoogleApiClient;

public class OnLoadServiceIntent extends IntentService {
    private GoogleApiClient client;

    public OnLoadServiceIntent() {
        super("onLoadPullData");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
    System.out.println(intent);
    System.out.println("Hello world");
        System.out.println("1st Client: "+this.client.hashCode()+ " 2d Client: " +BalourdosContainer.getGoogleClient().hashCode());
    }


    @Override
    public void onCreate() {
        this.client = BalourdosContainer.getGoogleClient();
        super.onCreate();
    }

}
