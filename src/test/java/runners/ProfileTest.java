package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/profile.feature"
        , plugin = {"utils.reports.Report"}
        , glue = "")
public class ProfileTest {
}
