package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class containing the methods to perform explicit waits
 */
public class Wait {
    private WebDriver driver;
    private static Wait instance;

    private Wait() {
        driver = BrowserManagement.getDriver();
    }

    public static Wait getInstance() {
        if (instance == null) {
            instance = new Wait();
        }
        return instance;
    }

    /**
     * Method that allows setting a wait according to a given condition and period of time
     * @param condition
     * @param timeout
     */
    private void waitForCondition(ExpectedCondition<?> condition, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

    /**
     * Method that expects a webelement to be visible for a certain time
     * @param timeout
     * @param element
     */
    public void untilElementIsVisible(int timeout, WebElement element) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(element);
        waitForCondition(condition, timeout);
    }
}
