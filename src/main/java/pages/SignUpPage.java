package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage{
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


    public SignUpPage() {
        super();
    }

    public String getTitleContainerPage(){
        return getTextElement(titleSingUpPage);
    }

    public void enterCredentials(String userName, String email, String password){
        sendKeystoElement(inputUserName, userName);
        sendKeystoElement(inputEmail, email);
        sendKeystoElement(inputPassword, password);
        clickElement(buttonSingUp);
    }
}
