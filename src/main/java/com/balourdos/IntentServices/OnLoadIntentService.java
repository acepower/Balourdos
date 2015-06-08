package com.balourdos.IntentServices;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import com.balourdos.BalourdosContainer;
import com.google.android.gms.common.api.GoogleApiClient;
import org.jdeferred.DoneCallback;
import org.jdeferred.FailCallback;

/**
 * Service to load data on Application Startup
 */
public class OnLoadIntentService extends IntentService {
    private GoogleApiClient client;

    private OnLoadIntentService() {
        super("onLoadPullData");
    }


    /**
     *
     * @param intent one-off intent on creation of the application to load data.
     *               Under normal Circumstances this service shouldn't be called more than once
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if(extras==null) {
        //todo
        }
        else {
            String intentCommand = extras.getString("appStage");
            if(intentCommand.equals("Startup")){
                this.onApplicationStartup();
            }
        }

    }


    @Override
    public void onCreate() {
        this.client = BalourdosContainer.getGoogleClient();
        super.onCreate();
    }

    /**
     * Do stuff when the application is created
     * Investiage what happens on recreation of the application
     */
    private void onApplicationStartup()
    {
        BalourdosContainer.googleConnect().done(new DoneCallback<String>() {
            @Override
            public void onDone(String successMessage) {
                System.out.println(successMessage);
            }
        }).fail(new FailCallback<Integer>() {
            @Override
            public void onFail(Integer errorCode) {
                System.out.println(errorCode);
            }
        });
    }

}
