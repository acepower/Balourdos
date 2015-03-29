package com.balourdos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.google.android.maps.MapView;

public class BalourdosActivity extends Activity {

    private MapView mapView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.balourdos_layout);
    }

    @Override
    public void onStart() {
        super.onStart();
        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText("Hellooooooooo!");
    }

}
