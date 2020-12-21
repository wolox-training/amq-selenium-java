package stepDefinitions;

import dtos.Articles;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ArticleCreateEditPage;
import pages.ArticleReadPage;
import utils.FakerManager;

import static dictionary.ErrorMessages.*;

public class StepsArticles {

    private ArticleCreateEditPage articlePage;
    private ArticleReadPage articleReadPage;


    public StepsArticles() {
        this.articlePage = new ArticleCreateEditPage();
        this.articleReadPage = new ArticleReadPage();
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
        Assert.assertTrue(FIELDS_BLANCK,articlePage.getErrorMessagesArticle().contains(FIELDS_ARTICLES_BLANCK));
    }

    @And("fill in all the fields of the article form")
    public void fillInAllTheFieldsOfTheArticleForm() {
        Articles.setTitleArticle(FakerManager.getInstance().getFaker().book().title());
        Articles.setAboutArticle(FakerManager.getInstance().getFaker().book().author());
        Articles.setContentArticle(FakerManager.getInstance().getFaker().address().fullAddress());
        Articles.setTagArticle(FakerManager.getInstance().getFaker().book().genre());
        articlePage.writeArticleTitle(Articles.getTitleArticle());
        articlePage.writeArticleAbout(Articles.getAboutArticle());
        articlePage.writeArticleContent(Articles.getContentArticle());
        articlePage.writeArticleTags(Articles.getTagArticle());
    }

    @Then("the article is created or edit successfully")
    public void theArticleIsCreatedSuccessfully() {
        Assert.assertEquals(ARTICLE_TITLE_ERROR,Articles.getTitleArticle(),articleReadPage.getTitleArticle());
        Assert.assertEquals(ARTICLE_TITLE_ERROR,Articles.getContentArticle(),articleReadPage.getContentArticle());
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
        Assert.assertEquals(ARTICLE_DELETE_ERROR,ARTICLES_DELETE_MSG,articleReadPage.getAlertMsg());
    }
}
