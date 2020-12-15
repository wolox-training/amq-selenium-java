package pages;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.BrowserManagement;
import utils.Wait;

public class BasePage {
    protected WebDriver driver;
    protected Wait wait;
    protected Dotenv dotenv;
    protected int timeOutSeconds;

    public BasePage() {
        driver = BrowserManagement.getDriver();
        dotenv = Dotenv.load();
        wait = Wait.getInstance();
        timeOutSeconds= Integer.parseInt(dotenv.get("TIME_SECONDS"));
        PageFactory.initElements
                (new AjaxElementLocatorFactory
                        (driver, timeOutSeconds), this);
    }
    protected void clickElement(WebElement element){
        wait.untilElementIsVisible(timeOutSeconds,element);
        element.click();
    }

    protected String getTextElement(WebElement element){
        wait.untilElementIsVisible(timeOutSeconds,element);
        return element.getText();
    }

    protected void sendKeystoElement(WebElement element, String value){
        wait.untilElementIsVisible(timeOutSeconds,element);
        element.sendKeys(value);
    }
}
