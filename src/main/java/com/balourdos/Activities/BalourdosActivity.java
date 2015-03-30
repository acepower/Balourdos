package com.balourdos.Activities;

import android.app.Activity;
import android.os.Bundle;
import com.balourdos.Controllers.BaseController;
import com.balourdos.R;

public class BalourdosActivity extends Activity {
    private BaseController controller;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.controller = (BaseController) getApplicationContext();
        this.startHomeScreen();
    }

    private void startHomeScreen() {
        setContentView(R.layout.home_screen_layout);
    }



}
