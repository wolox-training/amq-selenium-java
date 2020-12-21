package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.Assert;
import pages.SignInPage;
import utils.FakerManager;

import static dictionary.ErrorMessages.*;
import static dictionary.WebApplicationTexts.TITLE_SIGN_IN;

/**
 * Class containing the steps Definitions of the Sign In scenarios
 */
public class StepsSignIn {
    private SignInPage signInPage;
    private static Dotenv dotenv;

    public StepsSignIn() {
        this.signInPage = new SignInPage();
        this.dotenv = Dotenv.load();
    }

    @And("the system shows me the login form")
    public void theSystemShowsMeTheLoginForm() {
        Assert.assertEquals(TITLE_NOT_OBTAINED, TITLE_SIGN_IN, signInPage.getTitleContainerPage());
    }

    @When("I fill the email and password fields with existing data")
    public void iFillTheEmailAndPasswordFieldsWithExistingData() {
        signInPage.sendTextEmailField(dotenv.get("EMAIL"));
        signInPage.sendTextPasswordField(dotenv.get("PASSWORD"));
    }

    @And("I click the sign in button")
    public void iClickTheSignInButton() {
        signInPage.clickButtonSubmit();
    }

    @When("I leave the login form fields blank")
    public void iLeaveTheLoginFormFieldsBlank() {
        signInPage.sendTextEmailField("");
        signInPage.sendTextPasswordField("");
    }

    @Then("the system displays error messages corresponding to login blank fields")
    public void theSystemDisplaysErrorMessagesCorrespondingToLoginBlankFields() {
        Assert.assertTrue(FIELDS_BLANCK, signInPage.getErrorMessages().contains(FIELDS_LOGIN_BLANCK));
    }

    @When("I fill in the username with valid data")
    public void iFillInTheUsernameWithValidData() {
        signInPage.sendTextEmailField(dotenv.get("EMAIL"));
    }

    @And("I fill in the password with wrong data")
    public void iFillInThePasswordWithWrongData() {
        String password = FakerManager.getInstance().getFaker().internet().password(1,5);
        signInPage.sendTextPasswordField(password);
    }

    @And("I fill in the password with valid data")
    public void iFillInThePasswordWithValidData() {
        String password = FakerManager.getInstance().getFaker().internet().password();
        signInPage.sendTextPasswordField(password);
    }

    @Then("The system displays an error message for invalid data")
    public void theSystemDisplaysAnErrorMessageForInvalidData() {
        Assert.assertTrue(INVALID_DATA, signInPage.getErrorMessages().contains(FIELDS_LOGIN_INVALIDATE));
    }

    @And("Authentic me on the site")
    public void authenticMeOnTheSite() {
        signInPage.sendTextEmailField(dotenv.get("EMAIL"));
        signInPage.sendTextPasswordField(dotenv.get("PASSWORD"));
        signInPage.clickButtonSubmit();
    }

}
