package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SignUpPage;
import utils.FakerManager;

import java.util.Collections;

import static dictionary.ErrorMessages.*;

public class StepsSignUp {

    private SignUpPage singUpPage;

    public StepsSignUp() {
        this.singUpPage = new SignUpPage();
    }

    @And("the system shows me the registration form")
    public void theSystemShowsMeTheRegistrationForm() {
        Assert.assertEquals("The expected title was not obtained", "Sign Up", singUpPage.getTitleContainerPage());
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

    @And("I click the sign up button")
    public void iClickTheSignUpButton() throws InterruptedException {
        singUpPage.clickButtonSignUp();
    }

    @Then("the system displays a successful registration message")
    public void theSystemDisplaysASuccessfulRegistrationMessage() {
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
        Assert.assertTrue("Error message for existing email not found", singUpPage.getErrorMessages().containsAll(Collections.singleton(USER_NAME_ALREADY_EXISTS)));

    }

    @When("I leave the form fields blank")
    public void iLeaveTheFormFieldsBlank() {
        singUpPage.sendTextUserNameField("");
        singUpPage.sendTextEmailField("");
        singUpPage.sendTextPasswordField("");
    }

    @Then("the system displays error messages corresponding to blank fields")
    public void theSystemDisplaysErrorMessagesCorrespondingToBlankFields() {
        Assert.assertTrue("The messages obtained do not correspond to those expected from blank fields", getUserNameCanNotBlank().containsAll(singUpPage.getErrorMessages()));
    }

    @When("I fill in the username and password fields with valid data")
    public void iFillInTheUsernameAndPasswordFieldsWithValidData() {
        String userName = FakerManager.getInstance().getFaker().name().username().replace(".", "");
        String password = FakerManager.getInstance().getFaker().internet().password();
        singUpPage.sendTextUserNameField(userName);
        singUpPage.sendTextPasswordField(password);
    }

    @And("I fill out the email field with mail {string}")
    public void iFillOutTheEmailFieldWithMail(String email) {
        singUpPage.sendTextEmailField(email);
    }

    @Then("the system displays a message indicating that the mail already exists")
    public void theSystemDisplaysAMessageIndicatingThatTheMailAlreadyExists() {
        Assert.assertTrue("Error message for existing email not found", singUpPage.getErrorMessages().containsAll(Collections.singleton(EMAIL_ALREADY_EXISTS)));
    }

    @And("The system displays an error message in the email")
    public void theSystemDisplaysAErrorMessageEmail() {
        String msgError = singUpPage.getMsgValidationEmail();
        Assert.assertEquals("The error message in the mail field is not what is expected", String.format(EMAIL_INVALID_FORMAT_AT, singUpPage.getInputValueEmail()), msgError);
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
        Assert.assertTrue("Error message for short password not found", singUpPage.getErrorMessages().containsAll(Collections.singleton(PASSWORD_SHORT)));
    }

    @Then("In the html code the password is not written")
    public void inTheHtmlCodeThePasswordIsNotWritten() {
        String valuePassField = singUpPage.getInputValuePassword();
        Assert.assertTrue("Password is seen when inspecting password field", (valuePassField.isEmpty() || valuePassField.equals("")));
    }

    @Then("The email field is in invalid state")
    public void theEmailFieldIsInInvalidState() {
        Assert.assertFalse("The state of the field is not as expected", singUpPage.getStatusEmailField());
    }
}
