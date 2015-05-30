package com.balourdos.Controllers;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by kostas on 30-May-15.
 * The purpose of this Service is to load data on the creation of the main activity so that
 */
public class OnLoadController extends IntentService {

    public OnLoadController(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
