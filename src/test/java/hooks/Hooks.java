package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BrowserManagement;

public class Hooks {

    @Before
    public void initScenario() {
        BrowserManagement.initializeDriver();
    }

    @After
    public void finishScenario() {
        BrowserManagement.getDriver().quit();
    }
}
