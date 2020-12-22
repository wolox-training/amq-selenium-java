package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class contains the webelements of the login form
 */
public class ArticleCreateEditPage extends BasePage {

    @FindBy(className = "editor-page")
    private WebElement panelCreateEditorArticle;

    @FindBy(xpath = "//input[@placeholder='Article Title']")
    private WebElement inputArticleTitle;

    @FindBy(xpath = "//input[@placeholder=\"What's this article about?\"]")
    private WebElement inputArticleAbout;

    @FindBy(xpath = "//textarea[@placeholder='Write your article (in markdown)']")
    private WebElement inputArticleContent;

    @FindBy(xpath = "//input[@placeholder='Enter tags']")
    private WebElement inputArticleTags;

    @FindBy(xpath = "//button[normalize-space()='Publish Article']")
    private WebElement buttonPublishArticle;

    public ArticleCreateEditPage() {
        super();
    }

    public boolean getPanelFormArticle() {
        return panelCreateEditorArticle.isDisplayed();
    }

    public void writeArticleTitle(String title) {
        sendKeystoElement(inputArticleTitle, title);
    }

    public void clearFlieds() {
        deleteInformationFieldValue(inputArticleTitle);
        deleteInformationFieldValue(inputArticleAbout);
        cleanTextAreaField(inputArticleContent);
        deleteInformationFieldValue(inputArticleTags);
    }

    public void writeArticleAbout(String about) {
        sendKeystoElement(inputArticleAbout, about);
    }

    public void writeArticleContent(String content) {
        sendKeystoElement(inputArticleContent, content);
    }

    public void writeArticleTags(String tag) {
        sendKeystoElement(inputArticleTags, tag);
    }

    public void clickPublishButton() {
        clickElement(buttonPublishArticle);
    }

}
