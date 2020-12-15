package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(className = "logo-font")
    private WebElement logoBanner;

    public HomePage() {
        super();
    }
}
