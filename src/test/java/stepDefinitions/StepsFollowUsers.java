package stepDefinitions;

import dtos.Articles;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ArticlesFeedPage;
import pages.HomePage;
import pages.NavBarPage;
import pages.UsersPage;
import utils.DataManager;

import static dictionary.ErrorMessages.NO_FOUND_USER_ARTICLES;
import static dictionary.WebApplicationTexts.TITLE_FOLLOW_BUTTON;
import static dictionary.WebApplicationTexts.TITLE_UNFOLLOW_BUTTON;

/**
 * Class containing the stepsdefinitions related to favorite articles
 */
public class StepsFollowUsers {
    private ArticlesFeedPage articlesFeedPage;
    private UsersPage usersPage;
    private HomePage homePage;
    private NavBarPage navBarPage;

    public StepsFollowUsers() {
        this.articlesFeedPage = new ArticlesFeedPage();
        this.usersPage = new UsersPage();
        this.homePage = new HomePage();
        this.navBarPage = new NavBarPage();
    }

    @And("find a different user")
    public void findADifferentUser() {
        Articles articles = new Articles();
        articles.setAuthorArticle(articlesFeedPage.clickArticleByAnotherUser(DataManager.getInstance().getProfile().getUserName()));
        articles.setTitlesArticles(articlesFeedPage.articlesTitles());
        DataManager.getInstance().setArticles(articles);
    }

    @When("I click the follow-unfollow user button")
    public void iClickTheFollowUserButton() {
        usersPage.clickFollowUser();
    }

    @Then("button text changes by unfollowing user")
    public void buttonTextChangesByUnfollowingUser() {
        Assert.assertTrue(usersPage.getTextButton().contains(TITLE_UNFOLLOW_BUTTON));
    }

    @And("The articles of the user followed are listed in the Your Feed section")
    public void theArticlesOfTheUserFollowedAreListedInTheYourFeedSection() {
        navBarPage.clickHomeLink();
        Assert.assertArrayEquals(NO_FOUND_USER_ARTICLES, DataManager.getInstance().getArticles().getTitlesArticles().toArray(), articlesFeedPage.articlesTitles().toArray());
    }

    @Then("button text changes by following user")
    public void buttonTextChangesByFollowingUser() {
        Assert.assertTrue(usersPage.getTextButton().contains(TITLE_FOLLOW_BUTTON));
    }

    @And("Articles of the unfollowed user are removed from the Your Feed section")
    public void articlesOfTheUnfollowedUserAreRemovedFromTheYourFeedSection() {
        navBarPage.clickHomeLink();
        Assert.assertTrue(articlesFeedPage.articlesTitles().isEmpty());
    }

}
