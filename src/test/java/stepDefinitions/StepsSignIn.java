package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SignInPage;

import static dictionary.ErrorMessages.*;
import static dictionary.WebApplicationTexts.TITLE_SIGN_IN;

public class StepsSignIn {

    private SignInPage signInPage;

    public StepsSignIn() {
        this.signInPage = new SignInPage();
    }

    @And("the system shows me the login form")
    public void theSystemShowsMeTheLoginForm() {
        Assert.assertEquals(TITLE_NOT_OBTAINED, TITLE_SIGN_IN, signInPage.getTitleContainerPage());
    }

    @When("I fill the email and password fields with existing data")
    public void iFillTheEmailAndPasswordFieldsWithExistingData() {
        signInPage.sendCredentials();
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
}
