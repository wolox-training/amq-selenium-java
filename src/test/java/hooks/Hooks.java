package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BrowserManagement;

/**
 * Class that allows establishing the actions that will be executed before and after each scenario
 */
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
