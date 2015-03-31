package com.balourdos.Controllers;

import com.balourdos.Mocks.MockApplication;
import junit.framework.TestCase;

public class BaseControllerTest extends TestCase {

    private BaseController controller;
    private MockApplication app;

    public void setUp() {
        this.app = new MockApplication();
        this.controller = new BaseController(this.app);
    }

    public void testRandomTest() {
        this.app.gps.setLatitude(44.42);
        assertEquals(44.42, this.app.gps.getLatitude());
    }
}
