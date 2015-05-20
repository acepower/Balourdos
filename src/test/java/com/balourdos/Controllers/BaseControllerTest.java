package com.balourdos.Controllers;

import com.balourdos.Mocks.MockApplication;
import junit.framework.TestCase;

public class BaseControllerTest extends TestCase {

    private BaseController controller;
    private MockApplication app;

    public void setUp() {
        this.app = new MockApplication();
        this.controller = new BaseController();
    }
}
