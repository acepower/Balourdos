package com.balourdos.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.balourdos.BalourdosApplication;
import com.balourdos.Controllers.BaseController;
import com.balourdos.Controllers.OnLoadController;
import com.balourdos.R;

public class BalourdosActivity extends Activity {
    private BaseController controller;
    private Intent mServiceIntent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.controller = new BaseController();
        mServiceIntent = new Intent(BalourdosApplication.getContext(), OnLoadController.class);
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
