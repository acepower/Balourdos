package com.balourdos.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.balourdos.BalourdosApplication;
import com.balourdos.Controllers.BaseController;
import com.balourdos.Controllers.OnLoadController;
import com.balourdos.Modules.DaggerGoogleComponent;
import com.balourdos.Modules.GoogleComponent;
import com.balourdos.Modules.GoogleModule;
import com.balourdos.R;
import com.google.android.gms.common.api.GoogleApiClient;

public class BalourdosActivity extends Activity {
    private BaseController controller;
    private Intent serviceIntent;
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        GoogleComponent googleComponent = DaggerGoogleComponent.builder().googleModule(new GoogleModule()).build();
        this.client = googleComponent.provideGoogleApiClient();
        super.onCreate(savedInstanceState);
        this.controller = new BaseController();
        this.serviceIntent = new Intent(BalourdosApplication.getContext(), OnLoadController.class);
        this.startService(this.serviceIntent);
        this.startHomeScreen();
    }

    private void startHomeScreen() {
        setContentView(R.layout.home_screen_layout);
        EditText whereText = (EditText) findViewById(R.id.whereText);

        whereText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
