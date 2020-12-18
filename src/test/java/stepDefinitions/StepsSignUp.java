package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SignUpPage;
import utils.FakerManager;

import java.util.Collections;

import static dictionary.ErrorMessages.*;
import static dictionary.WebApplicationTexts.TITLE_SIGN_UP;

/**
 * Class containing the steps Definitions of the Sign Up scenarios
 */
public class StepsSignUp {
    private SignUpPage singUpPage;

    public StepsSignUp() {
        this.singUpPage = new SignUpPage();
    }

    @And("the system shows me the registration form")
    public void theSystemShowsMeTheRegistrationForm() {
        Assert.assertEquals(TITLE_NOT_OBTAINED, TITLE_SIGN_UP, singUpPage.getTitleContainerPage());
    }

    @When("I filled out the fields with valid values")
    public void iFilledOutTheFieldsWithValidValues() {
        String userName = FakerManager.getInstance().getFaker().name().username().replace(".", "");
        String email = FakerManager.getInstance().getFaker().internet().emailAddress();
        String password = FakerManager.getInstance().getFaker().internet().password();
        singUpPage.sendTextUserNameField(userName);
        singUpPage.sendTextEmailField(email);
        singUpPage.sendTextPasswordField(password);
    }

    @When("I filled in the fields with existing values {string}")
    public void iFilledInTheFieldsWithExistingValues(String userName) {
        String email = FakerManager.getInstance().getFaker().internet().emailAddress();
        String password = FakerManager.getInstance().getFaker().internet().password();
        singUpPage.sendTextUserNameField(userName);
        singUpPage.sendTextEmailField(email);
        singUpPage.sendTextPasswordField(password);
    }

    @Then("the system displays the error message indicating that the person already exists")
    public void theSystemDisplaysTheErrorMessageIndicatingThatThePersonAlreadyExists() {
        Assert.assertTrue(USER_NAME_EXISTING, singUpPage.getErrorMessages().containsAll(Collections.singleton(USER_NAME_ALREADY_EXISTS)));
    }

    @When("I leave the form fields blank")
    public void iLeaveTheFormFieldsBlank() {
        singUpPage.sendTextUserNameField("");
        singUpPage.sendTextEmailField("");
        singUpPage.sendTextPasswordField("");
    }

    @Then("the system displays error messages corresponding to blank fields")
    public void theSystemDisplaysErrorMessagesCorrespondingToBlankFields() {
        Assert.assertTrue(FIELDS_BLANCK, singUpPage.getErrorMessages().containsAll(FIELDS_CAN_NOT_BLANCK));
    }

    @When("I fill in the username and password fields with valid data")
    public void iFillInTheUsernameAndPasswordFieldsWithValidData() {
        String userName = FakerManager.getInstance().getFaker().name().username().replace(".", "");
        String password = FakerManager.getInstance().getFaker().internet().password();
        singUpPage.sendTextUserNameField(userName);
        singUpPage.sendTextPasswordField(password);
    }

    @Then("the system displays a message indicating that the mail already exists")
    public void theSystemDisplaysAMessageIndicatingThatTheMailAlreadyExists() {
        Assert.assertTrue(EMAIL_EXISTING, singUpPage.getErrorMessages().containsAll(Collections.singleton(EMAIL_ALREADY_EXISTS)));
    }

    @When("I fill in the username and email fields with valid data")
    public void iFillInTheUsernameAndEmailFieldsWithValidData() {
        String userName = FakerManager.getInstance().getFaker().name().username().replace(".", "");
        String email = FakerManager.getInstance().getFaker().internet().emailAddress();
        singUpPage.sendTextUserNameField(userName);
        singUpPage.sendTextEmailField(email);
    }

    @And("I fill out the password field with mail {string}")
    public void iFillOutThePasswordFieldWithMail(String password) {
        singUpPage.sendTextPasswordField(password);
    }

    @Then("The system displays an error message for the short pass")
    public void theSystemDisplaysAnErrorMessageForTheShortPass() {
        Assert.assertTrue(PASSWORD_SHORT, singUpPage.getErrorMessages().containsAll(Collections.singleton(PASSWORD_SHORT_FLIED)));
    }

    @Then("In the html code the password is not written")
    public void inTheHtmlCodeThePasswordIsNotWritten() {
        String valuePassField = singUpPage.getInputValuePassword();
        Assert.assertTrue(PASSWORD_ERROR_MSG, (valuePassField.isEmpty() || valuePassField.equals("")));
    }



}
