package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "//*[@class='error-messages']/li")
    protected List<WebElement> listErrorMsg;

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
        int con = 10;
        do {
            inputArticleTitle.clear();
            inputArticleAbout.clear();
            inputArticleContent.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
            inputArticleTags.clear();
            forceWait();
            con--;
        } while (!(inputArticleTitle.getAttribute(ATTRIBUTE_VALUE).isEmpty()
                && inputArticleAbout.getAttribute(ATTRIBUTE_VALUE).isEmpty()
                && inputArticleContent.getText().isEmpty()
                && inputArticleTags.getAttribute(ATTRIBUTE_VALUE).isEmpty())||con==0);
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

    public List<String> getErrorMessagesArticle() {
        List<String> msg = new ArrayList<>();
        for (WebElement element : listErrorMsg) {
            msg.add(element.getText());
        }
        return msg;
    }

}
