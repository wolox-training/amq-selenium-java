package pages;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.BrowserManagement;
import utils.Wait;

import java.util.ArrayList;
import java.util.List;

/**
 * This class groups the characteristics common to all pages
 */
public class BasePage {
    protected WebDriver driver;
    protected Wait wait;
    protected Dotenv dotenv;
    protected int timeOutSeconds;
    protected final String ATTRIBUTE_VALUE="value";

    @FindBy(className = "error-messages")
    protected WebElement panelErrorMsg;

    @FindBy(xpath = "//ul[@class='error-messages']/li")
    protected List<WebElement> listErrorMsg;

    public BasePage() {
        driver = BrowserManagement.getDriver();
        dotenv = Dotenv.load();
        wait = Wait.getInstance();
        timeOutSeconds = Integer.parseInt(dotenv.get("TIME_SECONDS"));
        PageFactory.initElements
                (new AjaxElementLocatorFactory
                        (driver, timeOutSeconds), this);
    }

    public List<String> getErrorMessages() {
        List<String> msg = new ArrayList<>();
        if (panelErrorMsg.isDisplayed()) {
            for (WebElement element : listErrorMsg) {
                msg.add(element.getText());
            }
        }
        return msg;
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
        wait.waitForClikableWebelement(timeOutSeconds, element);
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

    /**
     * With this method a forced wait is performed
     */
    protected void forceWait(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * This method verifies if a webelement is displayed
     * @param element
     * @return
     */
    protected boolean elementIsDisplayed(WebElement element){
        try{
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Receive the field and delete the information
     *
     * @param element
     */
    protected void deleteInformationFieldValue(WebElement element) {
        int con = 5;
        do {
            element.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
            forceWait();
            con--;
        } while (!(element.getAttribute(ATTRIBUTE_VALUE).isEmpty())&&con!=0);
    }

    protected void cleanTextAreaField(WebElement element){
        element.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }

    /**
     * This method waits until the page loads
     */
    public void waitForPageLoad(){
        wait.untilPageLoads(timeOutSeconds);
    }

}
