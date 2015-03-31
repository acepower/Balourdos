package com.balourdos.Controllers;

import com.balourdos.Mocks.MockApplication;
import junit.framework.TestCase;

public class BaseControllerTest extends TestCase {

    private MockApplication application;

    public void setUp() {
        this.application = new MockApplication();
    }

    public void testRandomTest() {
        this.application.gps.setLatitude(44.42);
        assertEquals(44.42, this.application.gps.getLatitude());
    }
}
