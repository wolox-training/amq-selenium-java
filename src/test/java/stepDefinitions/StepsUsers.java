package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ArticlesFeedPage;
import pages.HomePage;
import pages.NavBarPage;
import pages.UsersPage;
import utils.DataManager;

import static dictionary.WebApplicationTexts.WITHOUT_ARTICLES;

/**
 * Class containing the stepsdefinitions related to favorite articles
 */
public class StepsUsers {
    private ArticlesFeedPage articlesFeedPage;
    private UsersPage usersPage;
    private HomePage homePage;
    private NavBarPage navBarPage;

    public StepsUsers() {
        this.articlesFeedPage = new ArticlesFeedPage();
        this.usersPage = new UsersPage();
        this.homePage = new HomePage();
        this.navBarPage = new NavBarPage();
    }

    @And("the system displays the user's detail")
    public void theSystemDisplaysTheUserSDetail() {
        Assert.assertEquals(DataManager.getInstance().getArticles().getAuthorArticle(), usersPage.getUserName());
    }

    @Then("the user's articles are listed in the My articles section")
    public void theUserSArticlesAreListedInTheMyArticlesSection() {
        Assert.assertFalse(articlesFeedPage.articlesTitles().isEmpty());
    }

    @And("the favorite articles are listed in the Favorite Articles section if it is the case")
    public void theFavoriteArticlesAreListedInTheFavoriteArticlesSectionIfItIsTheCase() {
        homePage.clickFavoritedArticlesLink();
        Assert.assertTrue((!articlesFeedPage.articlesTitles().isEmpty()) || articlesFeedPage.getArticlePreviewText().equals(WITHOUT_ARTICLES));
    }
}
