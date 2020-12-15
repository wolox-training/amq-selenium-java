package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SignUpPage;
import utils.BrowserManagement;

public class StepsSignUp {

    private HomePage homePage;
    private SignUpPage singUpPage;
    private WebDriver driver;
    private static Dotenv dotenv= Dotenv.load();

    public StepsSignUp() {
        this.singUpPage = new SignUpPage();
        this.driver = BrowserManagement.getDriver();
    }

    @And("the system shows me the registration form")
    public void theSystemShowsMeTheRegistrationForm() {
    }
}
