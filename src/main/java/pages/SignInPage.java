package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class contains the webelements of the login form
 */
public class SignInPage extends CommonFormFields {

    @FindBy(xpath = "//div[@class='container page']//h1[text()='Sign In']")
    private WebElement titleSingInPage;

    public SignInPage() {
        super();
    }

    public String getTitleContainerPage() {
        return getTextElement(titleSingInPage);
    }


}
