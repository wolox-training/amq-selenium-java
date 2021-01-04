package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.BrowserManagement;
import utils.reports.Report;

/**
 * Class that allows establishing the actions that will be executed before and after each scenario
 */
public class Hooks {

    @Before
    public void initScenario(Scenario scenario) {
        BrowserManagement.initializeDriver();
        Report.logger().info(String.format("Start the scenario %s", scenario.getName()), true);
    }

    @After
    public void finishScenario() {
        BrowserManagement.getDriver().quit();
    }
}
