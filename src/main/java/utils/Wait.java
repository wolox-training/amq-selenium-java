package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Wait {

    private WebDriver driver;

    private static Wait instance;

    private Wait(){
        driver = BrowserManagement.getDriver();
    }

    public static Wait getInstance() {
        if(instance==null){
            instance=new Wait();
        }
        return instance;
    }

    private void waitForCondition(ExpectedCondition <?>condition, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

    public void untilPageLoads(int timeout) {
        ExpectedCondition<Object> condition = ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";");
        waitForCondition(condition, timeout);
    }

    public void untilElementIsDisplayed(int timeout, By locator) {
        ExpectedCondition<List<WebElement>> condition = ExpectedConditions.presenceOfAllElementsLocatedBy(locator);
        waitForCondition(condition, timeout);
    }

    public void untilElementIsVisible(int timeout, WebElement element) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(element);
        waitForCondition(condition, timeout);
    }
}
