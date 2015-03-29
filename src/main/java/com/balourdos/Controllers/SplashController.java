package com.balourdos.Controllers;

import android.app.Activity;
import android.widget.TextView;
import com.balourdos.R;

public class SplashController extends Activity {

    public SplashController() {

        setContentView(R.layout.home_screen_layout);

        TextView titleView = (TextView) findViewById(R.id.title_view);
        TextView whatView = (TextView) findViewById(R.id.what_view);
        TextView whereView = (TextView) findViewById(R.id.where_view);
    }
}
