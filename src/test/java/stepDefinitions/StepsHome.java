package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.NavBarPage;
import pages.SignUpPage;
import utils.BrowserManagement;

public class StepsHome {

    private HomePage homePage;
    private NavBarPage navBarPage;
    private static Dotenv dotenv= Dotenv.load();

    public StepsHome() {
        this.homePage = new HomePage();
        this.navBarPage = new NavBarPage();
    }
    @Given("^that I enter the conduit site$")
    public void enterConduitSite() {
        BrowserManagement.getDriver().get(dotenv.get("BASE_URL"));
    }

    @And("I click on the Sign Up link")
    public void iClickOnTheSignUpLink() {
        navBarPage.clickSingUpLink();
    }

}
