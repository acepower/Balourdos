package com.balourdos.Controllers;

import android.app.Activity;
import android.widget.TextView;
import com.balourdos.R;

public class BaseController extends Activity {

    public BaseController() {}

    public void getHomeScreen(String customText) {
        setContentView(R.layout.home_screen_layout);

        TextView titleView = (TextView) findViewById(R.id.title_view);
        titleView.setText("Balourdos");

        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText(customText);
    }
}
