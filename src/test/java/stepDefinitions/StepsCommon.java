package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonFormFields;

import static dictionary.ErrorMessages.EMAIL_ERROR_MSG;
import static dictionary.ErrorMessages.EMAIL_STATUS_ERROR_MSG;

public class StepsCommon {
    private CommonFormFields commonFormFields;

    public StepsCommon() {
        this.commonFormFields = new CommonFormFields();
    }

    @And("I fill out the email field with mail {string}")
    public void iFillOutTheEmailFieldWithMail(String email) {
        commonFormFields.sendTextEmailField(email);
    }

    @And("I click the submit button")
    public void iClickTheSignUpButton() throws InterruptedException {
        commonFormFields.clickButtonSubmit();
    }

    @Then("The email field is in invalid state")
    public void theEmailFieldIsInInvalidState() {
        Assert.assertFalse(EMAIL_STATUS_ERROR_MSG, commonFormFields.getStatusEmailField());
    }

    @And("The system displays an {string} error message in the email")
    public void theSystemDisplaysAErrorMessageEmail(String msgExpectedError) {
        String msgError = commonFormFields.getMsgValidationEmail();
        System.out.println(msgError);
        Assert.assertEquals(EMAIL_ERROR_MSG, msgExpectedError, msgError);
    }
}
