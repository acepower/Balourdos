package com.balourdos.IntentServices;

import android.app.IntentService;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import com.balourdos.BalourdosContainer;
import com.balourdos.Constants;
import com.balourdos.Models.GoogleLocation;
import com.balourdos.Models.LocationProcessing;
import com.google.android.gms.common.api.GoogleApiClient;
import org.jdeferred.DoneCallback;
import org.jdeferred.FailCallback;

import javax.xml.stream.Location;
import java.util.List;

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
            String intentCommand = extras.getString("appStage");
            if(intentCommand.equals("Startup")){
                BalourdosContainer.googleConnect().done(new DoneCallback<String>() {
                    @Override
                    public void onDone(String successMessage) {

//                       this code is reached before client is connected. the below statement returns false.
                        System.out.println(successMessage);
                        System.out.println("Is the client connected?"+client.isConnected());
                        System.out.println("Is the client attempting to connect?"+client.isConnecting());
                        location = GoogleLocation.getLocationObj(client);
                        test();
                    }
                }).fail(new FailCallback<Integer>() {
                    @Override
                    public void onFail(Integer errorCode) {
                        System.out.println(errorCode);
                    }
                });
            }
        }

    }


    @Override
    public void onCreate() {
        super.onCreate();
        client = BalourdosContainer.getGoogleClient();
    }

    private void test()
    {
        System.out.println("Is the client inside test connected? :"+this.client.isConnected());
        android.location.Location myLocation = this.location.getLastLocation();
        List<Address> addresses = LocationProcessing.getAddresses(myLocation.getLatitude(), myLocation.getLongitude(), Constants.ADDRESSES);
        if(addresses!=null) {
            for (Address in : addresses) {

                System.out.println("Address: "+in);
            }
        }
        else
            System.out.println("addresses are null");

    }

}
