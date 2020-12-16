package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SignUpPage extends BasePage {
    @FindBy(xpath = "//div[@class='container page']//h1[text()='Sign Up']")
    private WebElement titleSingUpPage;

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement inputUserName;
    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSingUp;

    @FindBy(className = "error-messages")
    private WebElement panelErrorMsg;
    @FindBy(xpath = "//ul[@class='error-messages']/li")
    private List<WebElement> listErrorMsg;


    public SignUpPage() {
        super();
    }

    public String getTitleContainerPage() {
        return getTextElement(titleSingUpPage);
    }

    public void sendTextPasswordField(String password) {
        sendKeystoElement(inputPassword, password);
    }

    public void sendTextUserNameField(String userName) {
        sendKeystoElement(inputUserName, userName);
    }

    public void sendTextEmailField(String email) {
        sendKeystoElement(inputEmail, email);
    }

    public void clickButtonSignUp() {
        clickElement(buttonSingUp);
    }

    public boolean getStatusEmailField() {
        return (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].validity.valid;", inputEmail);
    }

    public String getMsgValidationEmail() {
        return inputEmail.getAttribute("validationMessage");
    }

    public String getInputValueEmail() {
        return inputEmail.getAttribute("value");
    }

    public String getInputValuePassword() {
        return inputPassword.getAttribute("value");
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
