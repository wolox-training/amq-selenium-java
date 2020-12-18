package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.NavBarPage;

/**
 * Class containing the stepsdefinitions related to homePage and navBarPage
 */
public class StepsHome {
    private HomePage homePage;
    private NavBarPage navBarPage;

    public StepsHome() {
        this.homePage = new HomePage();
        this.navBarPage = new NavBarPage();
    }

    @Given("^that I enter the conduit site$")
    public void enterConduitSite() {
        homePage.enterTheWebsite();
    }

    @And("I click on the Sign Up link")
    public void iClickOnTheSignUpLink() {
        navBarPage.clickSingUpLink();
    }

    @Then("the system correctly registers the user")
    public void theSystemCorrectlyRegistersTheUser() {
        Assert.assertTrue(homePage.isVisibleImgUser());
    }

    @And("I click on the Sign In link")
    public void iClickOnTheSignInLink() {
        navBarPage.clickSingInLink();
    }
}
