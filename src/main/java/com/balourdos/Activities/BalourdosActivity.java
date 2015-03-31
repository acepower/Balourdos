package com.balourdos.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.balourdos.BalourdosApplication;
import com.balourdos.Controllers.BaseController;
import com.balourdos.Models.GoogleLocation;
import com.balourdos.R;

public class BalourdosActivity extends Activity {
    private BaseController controller;
    private GoogleLocation location;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BalourdosApplication balourdosApplication = new BalourdosApplication();
        this.controller = new BaseController(balourdosApplication);
        this.location = new GoogleLocation(getApplicationContext());
        this.startHomeScreen();

    }

    private void startHomeScreen() {
        setContentView(R.layout.home_screen_layout);
        EditText whereText = (EditText) findViewById(R.id.whereText);

        whereText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.getCurrentLocation();
            }
        });
    }



}
