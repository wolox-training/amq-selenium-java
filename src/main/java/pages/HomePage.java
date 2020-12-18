package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class contains the webelements of the home page
 */
public class HomePage extends BasePage {

    @FindBy(className = "user-pic")
    private WebElement imgUser;

    public HomePage() {
        super();
    }

    public boolean isVisibleImgUser(){
        return imgUser.isDisplayed();
    }
}
