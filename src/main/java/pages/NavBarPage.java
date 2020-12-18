package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class contains the webelements of the nav bar page
 */
public class NavBarPage extends BasePage {

    @FindBy(linkText = "Sign up")
    private WebElement lnkSignUp;

    @FindBy(linkText = "Sign in")
    private WebElement lnkSignIn;

    public NavBarPage() {
        super();
    }

    public void clickSingUpLink() {
        clickElement(lnkSignUp);
    }

    public void clickSingInLink() {
        clickElement(lnkSignIn);
    }
}
