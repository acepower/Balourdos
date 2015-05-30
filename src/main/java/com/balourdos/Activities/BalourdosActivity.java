package com.balourdos.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import com.balourdos.Controllers.BaseController;
import com.balourdos.IntentServices.OnLoadIntentService;
import com.balourdos.BalourdosContainer;
import com.balourdos.R;
import com.google.android.gms.common.api.GoogleApiClient;

public class BalourdosActivity extends Activity {
    private BaseController controller;
    private Intent serviceIntent;
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.init();
        this.startService(this.serviceIntent);
        this.startHomeScreen();
    }

    private void init() {
        this.client = BalourdosContainer.getGoogleClient();
        this.controller = new BaseController();
        this.serviceIntent = new Intent(this, OnLoadIntentService.class);
    }


    private void startHomeScreen() {
        setContentView(R.layout.home_screen_layout);
        EditText whereText = (EditText) findViewById(R.id.whereText);
    }
}
