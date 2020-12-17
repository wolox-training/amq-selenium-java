package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends CommonFormFields {

    @FindBy(xpath = "//div[@class='container page']//h1[text()='Sign In']")
    private WebElement titleSingInPage;

    public SignInPage() {
        super();
    }

    public String getTitleContainerPage() {
        return getTextElement(titleSingInPage);
    }

    public void sendCredentials() {
        inputEmail.sendKeys(dotenv.get("EMAIL"));
        inputPassword.sendKeys(dotenv.get("PASSWORD"));
    }

}
