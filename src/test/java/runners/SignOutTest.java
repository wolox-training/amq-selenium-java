package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/signout.feature"
        , plugin = {"pretty"}
        , glue = "")
public class SignOutTest {
}
