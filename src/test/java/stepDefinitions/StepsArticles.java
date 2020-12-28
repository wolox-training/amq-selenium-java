package stepDefinitions;

import dtos.Articles;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ArticleCreateEditPage;
import pages.ArticleReadPage;
import pages.ArticlesFeedPage;
import utils.DataManager;
import utils.FakerManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static dictionary.ErrorMessages.*;

public class StepsArticles {

    private ArticleCreateEditPage articlePage;
    private ArticleReadPage articleReadPage;
    private ArticlesFeedPage articlesFeedPage;

    public StepsArticles() {
        this.articlePage = new ArticleCreateEditPage();
        this.articleReadPage = new ArticleReadPage();
        this.articlesFeedPage = new ArticlesFeedPage();
    }

    @And("the system shows me a form to create or edit an article")
    public void theSystemShowsMeAFormToCreateAnArticle() {
        Assert.assertTrue(DO_NOT_SHOW_EDITOR_PANEL, articlePage.getPanelFormArticle());
    }

    @And("the article creation fields are left empty")
    public void theArticleCreationFieldsAreLeftEmpty() {
        articlePage.writeArticleTitle("");
        articlePage.writeArticleAbout("");
        articlePage.writeArticleContent("");
        articlePage.writeArticleTags("");
    }

    @And("click on the Publish Article button")
    public void clickOnThePublishArticleButton() {
        articlePage.clickPublishButton();
    }

    @Then("the system displays the error message indicating that the fields should not be empty")
    public void theSystemDisplaysTheErrorMessageIndicatingThatTheFieldsShouldNotBeEmpty() {
        Assert.assertTrue(FIELDS_BLANCK, articlePage.getErrorMessages().contains(FIELDS_ARTICLES_BLANCK));
    }

    @And("fill in all the fields of the article form")
    public void fillInAllTheFieldsOfTheArticleForm() {
        Articles articles = new Articles();
        articles.setTitleArticle(FakerManager.getInstance().getFaker().book().title());
        articles.setAboutArticle(FakerManager.getInstance().getFaker().book().author());
        articles.setContentArticle(FakerManager.getInstance().getFaker().address().fullAddress());
        articles.setTagArticle(FakerManager.getInstance().getFaker().book().genre());
        articlePage.writeArticleTitle(articles.getTitleArticle());
        articlePage.writeArticleAbout(articles.getAboutArticle());
        articlePage.writeArticleContent(articles.getContentArticle());
        articlePage.writeArticleTags(articles.getTagArticle());
        DataManager.getInstance().setArticles(articles);
    }

    @Then("the article is created or edit successfully")
    public void theArticleIsCreatedSuccessfully() {
        Articles articles = DataManager.getInstance().getArticles();
        Assert.assertEquals(ARTICLE_TITLE_ERROR, articles.getTitleArticle(), articleReadPage.getTitleArticle());
        Assert.assertEquals(ARTICLE_CONTENT_ERROR, articles.getContentArticle(), articleReadPage.getContentArticle());
    }

    @And("I create an article")
    public void iCreateAnArticle() throws InterruptedException {
        fillInAllTheFieldsOfTheArticleForm();
        clickOnThePublishArticleButton();
    }

    @When("I click the edit button")
    public void iClickTheEditButton() {
        articleReadPage.clickEditLink();
        articlePage.clearFlieds();
    }

    @When("I click the delete button")
    public void iClickTheDeleteButton() {
        articleReadPage.clickDeleteLink();
    }

    @Then("the article was successfully removed")
    public void theArticleWasSuccessfullyRemoved() {
        Assert.assertEquals(ARTICLE_DELETE_ERROR, ARTICLES_DELETE_MSG, articleReadPage.getAlertMsg());
    }

    @And("the system displays the list of items")
    public void theSystemDisplaysTheListOfItems() {
        Assert.assertFalse(articlesFeedPage.articlesTitles().isEmpty());
        Articles articles = new Articles();
        articles.setTitleArticle(randomText(articlesFeedPage.articlesTitles()));
        DataManager.getInstance().setArticles(articles);
    }

    @And("click on an article title in the list")
    public void clickOnAnArticleTitleInTheList() {
        articlesFeedPage.clickSpecificTitleArticle(DataManager.getInstance().getArticles().getTitleArticle());
    }

    @And("the system opens the article information")
    public void theSystemOpensTheArticleInformation() {
        Assert.assertEquals(ARTICLE_TITLE_ERROR, DataManager.getInstance().getArticles().getTitleArticle(), articleReadPage.getTitleArticle());
    }

    private String randomText(List<String> text) {
        Random random = new Random();
        return text.get(random.nextInt(text.size()));
    }

    @And("write a comment to the article")
    public void writeACommentToTheArticle() {
        Articles articles = new Articles();
        articles.setCommentArticle(FakerManager.getInstance().getFaker().country().name());
        DataManager.getInstance().setArticles(articles);
        articleReadPage.sendCommentArticle(DataManager.getInstance().getArticles().getCommentArticle());
    }

    @And("I click post comment")
    public void iClickPostComment() {
        articleReadPage.clickPostComment();
    }

    @Then("the new comment is added to the article")
    public void theNewCommentIsAddedToTheArticle() {
        Assert.assertEquals(DataManager.getInstance().getArticles().getCommentArticle(), articleReadPage.getCommentCard());
    }

    @And("write a blank comment to the article")
    public void writeABlankCommentToTheArticle() {
        articleReadPage.sendCommentArticle("");
    }

    @Then("the system displays the error message by blank comment")
    public void theSystemDisplaysTheErrorMessageByBlankComment() {
        Assert.assertEquals(BLANK_COMMENT_ERROR, COMMENT_ARTICLES_BLANCK, articleReadPage.getAlertMsg());
    }

    @And("the author and the date of the comment are displayed")
    public void theAuthorAndTheDateOfTheCommentAreDisplayed() {
        Assert.assertEquals(DataManager.getInstance().getProfile().getUserName(), articleReadPage.getAuthorComment());
        Date objDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy", Locale.ENGLISH);
        Assert.assertEquals(format.format(objDate), articleReadPage.getDateComment());
    }

    @And("the comment is removed")
    public void theCommentIsRemoved() {
        articleReadPage.clickDeleteCommentButton();
    }
}
