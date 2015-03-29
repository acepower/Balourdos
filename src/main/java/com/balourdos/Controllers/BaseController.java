package com.balourdos.Controllers;

import android.app.Activity;
import android.widget.TextView;
import com.balourdos.R;

public class BaseController extends Activity {

    public BaseController() {}

    public void getHomeScreen() {
        setContentView(R.layout.home_screen_layout);

        TextView titleView = (TextView) findViewById(R.id.title_view);
        TextView whatView = (TextView) findViewById(R.id.what_view);
        TextView whereView = (TextView) findViewById(R.id.where_view);
    }
}
