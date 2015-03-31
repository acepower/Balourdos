package com.balourdos.Mocks;

import android.app.Application;

public class MockApplication {
    public MockApplication() {}

    public MockGPSTracker gps = new MockGPSTracker(this);
}
