package pages;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import utils.BrowserManagement;
import utils.Wait;

public class BasePage {
    protected WebDriver driver;
    protected Wait wait;
    protected Dotenv dotenv;

    public BasePage() {
        driver = BrowserManagement.getDriver();
        dotenv = Dotenv.load();
        wait = Wait.getInstance();
    }
}
