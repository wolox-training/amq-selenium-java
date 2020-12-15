package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBarPage extends BasePage{
    @FindBy(linkText = "Sign up")
    private WebElement lnkSignUp;

    public NavBarPage() {
        super();
    }

    public void clickSingUpLink(){
        clickElement(lnkSignUp);
    }
}
