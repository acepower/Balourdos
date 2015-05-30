package com.balourdos.IntentServices;

import android.app.IntentService;
import android.content.Intent;
import com.balourdos.BalourdosContainer;
import com.google.android.gms.common.api.GoogleApiClient;
import org.jdeferred.DoneCallback;
import org.jdeferred.FailCallback;

public class OnLoadServiceIntent extends IntentService {
    private GoogleApiClient client;

    public OnLoadServiceIntent() {
        super("onLoadPullData");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        BalourdosContainer.googleConnect().done(new DoneCallback() {
            @Override
            public void onDone(Object successMessage) {
                System.out.println(successMessage.toString());
            }
        }).fail(new FailCallback() {
            @Override
            public void onFail(Object errorCode) {
                System.out.println(errorCode.toString());
            }
        });
    }


    @Override
    public void onCreate() {
        this.client = BalourdosContainer.getGoogleClient();
        super.onCreate();
    }

}
