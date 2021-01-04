package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class contains the webelements of the register form
 */
public class UsersPage extends BasePage {

    @FindBy(xpath = "//*[@class='user-info']//div/h4")
    private WebElement titleUserName;

    @FindBy(css = ".action-btn")
    private WebElement followUser;

    public UsersPage() {
        super();
    }

    public String getUserName(){
        return getTextElement(titleUserName);
    }

    public void clickFollowUser(){
        clickElement(followUser);
        forceWait();
    }

    public String getTextButton(){
        return getTextElement(followUser);
    }

}
