package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * This class contains the webelements of the home page
 */
public class HomePage extends BasePage {

    @FindBy(className = "user-pic")
    private WebElement imgUser;

    @FindBy(linkText = "Your Feed")
    private WebElement lnkYourFeed;

    @FindBy(linkText = "Global Feed")
    private WebElement lnkGlobalFeed;

    @FindBy(linkText = "My Articles")
    private WebElement lnkMyArticles;

    @FindBy(linkText = "Favorited Articles")
    private WebElement lnkFavoritedArticles;

    @FindBy(css = ".preview-link>h1")
    private List<WebElement> listArticles;

    @FindBy(linkText = "Edit Profile Settings")
    private WebElement lnkEditProfileSettings;

    @FindBy(css = ".article-preview:nth-child(1) .btn-sm")
    private WebElement heartIcon;

    @FindBy(xpath = "//a[@href='/settings']")
    private WebElement lnkSettings;

    public HomePage() {
        super();
    }

    public boolean isVisibleImgUser() {
        return imgUser.isDisplayed();
    }

    public void clickGlobalFeedLnk() {
        clickElement(lnkGlobalFeed);
    }

    public String getFirstArticle() {
        return getTextElement(listArticles.get(0));
    }

    public void clickUserPic() {
        clickElement(imgUser);
    }

    public boolean isVisibleYourFeedLink() {
        forceWait();
        return elementIsDisplayed(lnkYourFeed);
    }

    public void clickYourFeedLink() {
        clickElement(lnkYourFeed);
    }

    public boolean isVisibleMyArticlesLink() {
        forceWait();
        return elementIsDisplayed(lnkMyArticles);
    }

    public boolean isVisibleFavoritedArticles() {
        return elementIsDisplayed(lnkFavoritedArticles);
    }

    public void clickFavoritedArticlesLink() {
        clickElement(lnkFavoritedArticles);
    }

    public void clickEditProfileSettingsLink() {
        clickElement(lnkEditProfileSettings);
    }

    public void clickSettingsLink() {
        clickElement(lnkSettings);
    }

    public String getUserNameLink() {
        return imgUser.getAttribute("alt");
    }

    public void waitForUserNameChange(String userName) {
        wait.waitForAttributeValue(timeOutSeconds, imgUser, "alt", userName);
    }

    public int getAmountFavorites() {
        return Integer.parseInt(getTextElement(heartIcon));
    }

    public void clickFavoriteIcon() {
        clickElement(heartIcon);
        forceWait();
    }
}
