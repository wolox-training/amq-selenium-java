package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class contains the webelements of the register form
 */
public class SignUpPage extends CommonFormFields {

    @FindBy(xpath = "//div[@class='container page']//h1[text()='Sign Up']")
    private WebElement titleSingUpPage;

    @FindBy(xpath = "//input[@placeholder='Username']")
    protected WebElement inputUserName;


    public SignUpPage() {
        super();
    }

    public String getTitleContainerPage() {
        return getTextElement(titleSingUpPage);
    }

    public void sendTextUserNameField(String userName) {
        sendKeystoElement(inputUserName, userName);
    }

    public String getValuerUserNameField(){
        return inputUserName.getAttribute(ATTRIBUTE_VALUE);
    }

    public String getInputValuePassword() {
        return inputPassword.getAttribute(ATTRIBUTE_VALUE);
    }




}
