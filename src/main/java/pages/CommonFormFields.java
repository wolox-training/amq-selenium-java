package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(className = "error-messages")
    protected WebElement panelErrorMsg;

    @FindBy(xpath = "//ul[@class='error-messages']/li")
    protected List<WebElement> listErrorMsg;

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
    public List<String> getErrorMessages() {
        List<String> msg = new ArrayList<>();
        if (panelErrorMsg.isDisplayed()) {
            for (WebElement element : listErrorMsg) {
                msg.add(element.getText());
            }
        }
        return msg;
    }
}
