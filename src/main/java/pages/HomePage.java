package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
