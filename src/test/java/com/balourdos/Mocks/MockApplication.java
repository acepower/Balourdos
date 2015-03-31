package com.balourdos.Mocks;

import com.balourdos.BalourdosApplication;

public class MockApplication extends BalourdosApplication {
    public MockApplication() {}

    public MockGPSTracker gps = new MockGPSTracker(this);
}
