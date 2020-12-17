package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SignUpPage extends CommonFormFields {

    @FindBy(xpath = "//div[@class='container page']//h1[text()='Sign Up']")
    private WebElement titleSingUpPage;
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement inputUserName;


    public SignUpPage() {
        super();
    }

    public String getTitleContainerPage() {
        return getTextElement(titleSingUpPage);
    }

    public void sendTextUserNameField(String userName) {
        sendKeystoElement(inputUserName, userName);
    }


    public String getInputValuePassword() {
        return inputPassword.getAttribute("value");
    }

    public boolean getStatusEmailField() {
        return (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].validity.valid;", inputEmail);
    }


}
