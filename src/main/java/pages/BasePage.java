package pages;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.BrowserManagement;
import utils.Wait;

/**
 * This class groups the characteristics common to all pages
 */
public class BasePage {
    protected WebDriver driver;
    protected Wait wait;
    protected Dotenv dotenv;
    protected int timeOutSeconds;

    public BasePage() {
        driver = BrowserManagement.getDriver();
        dotenv = Dotenv.load();
        wait = Wait.getInstance();
        timeOutSeconds = Integer.parseInt(dotenv.get("TIME_SECONDS"));
        PageFactory.initElements
                (new AjaxElementLocatorFactory
                        (driver, timeOutSeconds), this);
    }

    /**
     * This method enters the url of the web application
     */
    public void enterTheWebsite() {
        driver.get(dotenv.get("BASE_URL"));
    }

    /**
     * This method receives a webelement, waits for it to be visible and clicks on it
     * @param element
     */
    protected void clickElement(WebElement element) {
        wait.untilElementIsVisible(timeOutSeconds, element);
        element.click();
    }

    /**
     * This method receives a webelement, expects it to be visible, and gets the text of the element
     * @param element
     * @return
     */
    protected String getTextElement(WebElement element) {
        wait.untilElementIsVisible(timeOutSeconds, element);
        return element.getText();
    }

    /**
     * This method receives a webelement and a string, expects the element to be visible and sends it the string
     * @param element
     * @param value
     */
    protected void sendKeystoElement(WebElement element, String value) {
        wait.untilElementIsVisible(timeOutSeconds, element);
        element.sendKeys(value);
    }

}
