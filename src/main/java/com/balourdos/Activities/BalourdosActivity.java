package com.balourdos.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
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

        TextView titleView = (TextView) findViewById(R.id.title_view);
        TextView whatView = (TextView) findViewById(R.id.what_view);
        TextView whereView = (TextView) findViewById(R.id.where_view);
    }

}
