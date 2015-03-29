package com.balourdos;

import android.app.Activity;
import android.os.Bundle;
import com.balourdos.Controllers.BaseController;

public class BalourdosActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        BaseController baseController = new BaseController();
        baseController.getHomeScreen();
    }

}
