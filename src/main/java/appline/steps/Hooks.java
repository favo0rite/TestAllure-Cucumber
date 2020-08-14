package appline.steps;

import appline.managers.InitManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {
    @Before
    public static void setUp() {
        InitManager.initFramework();
    }

    @After
    public static void tearDown() {
        InitManager.quitFramework();
    }
}


