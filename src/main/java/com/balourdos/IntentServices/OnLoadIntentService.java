package com.balourdos.IntentServices;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import com.balourdos.BalourdosContainer;
import com.balourdos.Constants;
import com.balourdos.Models.GoogleLocation;
import com.balourdos.Models.LocationProcessing;
import com.google.android.gms.common.api.GoogleApiClient;
import org.jdeferred.DoneCallback;
import org.jdeferred.FailCallback;

import javax.xml.stream.Location;

/**
 * Service to load data on Application Startup
 */
public class OnLoadIntentService extends IntentService {
    private GoogleApiClient client;
    private GoogleLocation location;

    public OnLoadIntentService() {
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
            throw new NullPointerException("Extras are not meant to be null");
        }
        else {
            System.out.println("extras not null");
            String intentCommand = extras.getString("appStage");
            if(intentCommand.equals("Startup")){
                System.out.println("extras == startup");
                this.onApplicationStartup();
            }
        }

    }


    @Override
    public void onCreate() {
        this.client = BalourdosContainer.getGoogleClient();
        this.location = GoogleLocation.getLocationObj(this.client);
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
                System.out.println("Connected to google play");
                test();
            }
        }).fail(new FailCallback<Integer>() {
            @Override
            public void onFail(Integer errorCode) {
                System.out.println(errorCode);
            }
        });
    }

    private void test()
    {
        android.location.Location myLocation = this.location.getLastLocation();
        System.out.println("Adresses : ");
        System.out.println(LocationProcessing.getAddresses(myLocation.getLatitude(), myLocation.getLongitude(), Constants.ADDRESSES));

    }

}
