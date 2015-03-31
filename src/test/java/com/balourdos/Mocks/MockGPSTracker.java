package com.balourdos.Mocks;

public class MockGPSTracker {
    private double latitude;
    private double longitude;
    private boolean canGetLocation;
    private MockApplication mContext;

    public MockGPSTracker(MockApplication context) {
        this.mContext = context;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongtitude(double longitude) {
        this.longitude = longitude;
    }

    public void setCanGetLocation(boolean canGetLocation) {
        this.canGetLocation = canGetLocation;
    }

    public boolean canGetLocation() {
        return this.canGetLocation;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }
}
