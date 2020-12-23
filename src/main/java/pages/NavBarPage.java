package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class contains the webelements of the nav bar page
 */
public class NavBarPage extends BasePage {

    @FindBy(linkText = "Home")
    private WebElement lnkHome;

    @FindBy(linkText = "Sign up")
    private WebElement lnkSignUp;

    @FindBy(linkText = "Sign in")
    private WebElement lnkSignIn;

    @FindBy(linkText = "New Post")
    private WebElement lnkNewPost;


    public NavBarPage() {
        super();
    }

    public void clickSingUpLink() {
        clickElement(lnkSignUp);
    }

    public void clickSingInLink() {
        clickElement(lnkSignIn);
    }

    public void clickNewPostLink() {
        clickElement(lnkNewPost);
    }

    public void clickHomeLink() {
        clickElement(lnkHome);
    }

    public boolean isVisibleSignInLink(){
        return elementIsDisplayed(lnkSignIn);
    }
}
