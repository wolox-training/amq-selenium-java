package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class contains the common webelements of the Sign In and Sign Up forms
 */
public class CommonFormFields extends BasePage{

    @FindBy(xpath = "//input[@placeholder='Email']")
    protected WebElement inputEmail;

    @FindBy(xpath = "//input[@placeholder='Password']")
    protected WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement buttonSubmit;

    public CommonFormFields() {
        super();
    }

    public void sendTextPasswordField(String password) {
        sendKeystoElement(inputPassword, password);
    }

    public void sendTextEmailField(String email) {
        sendKeystoElement(inputEmail, email);
    }

    public void clickButtonSubmit() {
        clickElement(buttonSubmit);
    }

    public String getMsgValidationEmail() {
        return inputEmail.getAttribute("validationMessage");
    }

    public boolean getStatusEmailField() {
        return (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].validity.valid;", inputEmail);
    }

    public String getValuerEmailField(){
        return inputEmail.getAttribute(ATTRIBUTE_VALUE);
    }
}
