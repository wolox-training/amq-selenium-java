package stepDefinitions;

import dtos.Profile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.NavBarPage;
import utils.DataManager;

import static dictionary.ErrorMessages.ARTICLE_NOT_FOUND_GLOBAL_FEED;
import static dictionary.ErrorMessages.USER_NAME_PROFILE_ERROR;

/**
 * Class containing the stepsdefinitions related to homePage and navBarPage
 */
public class StepsHome {
    private HomePage homePage;
    private NavBarPage navBarPage;

    public StepsHome() {
        this.homePage = new HomePage();
        this.navBarPage = new NavBarPage();
    }

    @Given("^that I enter the conduit site$")
    public void enterConduitSite() {
        homePage.enterTheWebsite();
    }

    @And("I click on the Sign Up link")
    public void iClickOnTheSignUpLink() {
        navBarPage.clickSingUpLink();
    }

    @Then("the system correctly registers the user")
    public void theSystemCorrectlyRegistersTheUser() {
        Assert.assertTrue(homePage.isVisibleImgUser());
    }

    @And("I click on the Sign In link")
    public void iClickOnTheSignInLink() {
        navBarPage.clickSingInLink();
    }

    @When("I click on the New Post link")
    public void iClickOnTheNewPostLink() {
        navBarPage.clickNewPostLink();
    }

    @When("I click on the Home link")
    public void iClickOnTheHomeLink() {
        navBarPage.clickHomeLink();
    }

    @And("I click on the Global Feed link")
    public void iClickOnTheGlobalFeedLink() {
        Profile profile = new Profile();
        profile.setUserName(homePage.getUserNameLink());
        DataManager.getInstance().setProfile(profile);
        homePage.clickGlobalFeedLnk();
    }

    @Then("the article is in the first position of the list")
    public void theArticleIsInTheFirstPositionOfTheList() {
        Assert.assertEquals(ARTICLE_NOT_FOUND_GLOBAL_FEED, DataManager.getInstance().getArticles().getTitleArticle(), homePage.getFirstArticle());
    }

    @When("I click on the user name")
    public void iClickOnTheUserName() {
        homePage.clickUserPic();
    }

    @And("the system displays the Your Feed and Global Feed links")
    public void theSystemDisplaysTheYourFeedAndGlobalFeedLinks() {
        if (!homePage.isVisibleYourFeedLink()) {
            iClickOnTheHomeLink();
        }
        Assert.assertTrue(homePage.isVisibleYourFeedLink());
    }

    @And("the system displays the My Articles and Favorited Articles links")
    public void theSystemDisplaysTheMyArticlesAndFavoritedArticlesLinks() {
        if (!homePage.isVisibleMyArticlesLink()) {
            iClickOnTheUserName();
        }
        Assert.assertTrue(homePage.isVisibleMyArticlesLink());
        Assert.assertTrue(homePage.isVisibleFavoritedArticles());
    }

    @And("I click the Edit Profile Settings link")
    public void iClickTheEditProfileSettingsLink() {
        homePage.clickEditProfileSettingsLink();
    }

    @And("the username is updated in the navigation bar")
    public void theUsernameIsUpdatedInTheNavigationBar() {
        homePage.waitForUserNameChange(DataManager.getInstance().getProfile().getUserName());
        Assert.assertEquals(USER_NAME_PROFILE_ERROR, DataManager.getInstance().getProfile().getUserName(), homePage.getUserNameLink());
        homePage.clickUserPic();
        iClickTheEditProfileSettingsLink();
    }

    @When("I click on the Settings link")
    public void iClickOnTheSettingsLink() {
        homePage.clickSettingsLink();
    }

    @And("the sign in option is displayed again")
    public void theSignInOptionIsDisplayedAgain() {
        Assert.assertTrue(navBarPage.isVisibleSignInLink());
    }

    @And("I wait for the page to load")
    public void iWaitThePageToLoad() {
        homePage.waitForPageLoad();
    }


}
