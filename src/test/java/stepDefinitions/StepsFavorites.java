package stepDefinitions;

import dtos.Articles;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.NavBarPage;
import utils.DataManager;

/**
 * Class containing the stepsdefinitions related to favorite articles
 */
public class StepsFavorites {
    private HomePage homePage;
    private NavBarPage navBarPage;

    public StepsFavorites() {
        this.homePage = new HomePage();
        this.navBarPage = new NavBarPage();
    }

    @And("captured the number of favorites for the first item on the list")
    public void capturedTheNumberOfFavoritesForTheFirstItemOnTheList() {
        Articles articles = new Articles();
        articles.setAmountFavorites(homePage.getAmountFavorites());
        articles.setTitleArticle(homePage.getFirstArticle());
        DataManager.getInstance().setArticles(articles);
    }

    @When("I click on the favorites option of the first item in the list")
    public void iClickOnTheFavoritesOptionOfTheFirstItemInTheList() {
        homePage.clickFavoriteIcon();
    }

    @Then("the number of favorites does not change")
    public void theNumberOfFavoritesDoesNotChange() {
        Assert.assertEquals(DataManager.getInstance().getArticles().getAmountFavorites(), homePage.getAmountFavorites());
    }

    @Then("the number of favorites increases by one")
    public void theNumberOfFavoritesIncreasesByOne() {
        Assert.assertEquals(homePage.getAmountFavorites(), (DataManager.getInstance().getArticles().getAmountFavorites() + 1));
    }

    @And("is displayed in the Favorited Articles section of the profile")
    public void isDisplayedInTheFavoritedArticlesSectionOfTheProfile() {
        homePage.clickUserPic();
        homePage.clickFavoritedArticlesLink();
        Assert.assertEquals(DataManager.getInstance().getArticles().getTitleArticle(), homePage.getFirstArticle());
    }

    @And("It is displayed in the Your Feed section of the main page")
    public void itIsDisplayedInTheYourFeedSectionOfTheMainPage() {
        navBarPage.clickHomeLink();
        homePage.clickYourFeedLink();
        Assert.assertEquals(DataManager.getInstance().getArticles().getTitleArticle(), homePage.getFirstArticle());
    }
}
