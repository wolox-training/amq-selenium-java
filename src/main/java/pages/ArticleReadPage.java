package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class contains the webelements of the login form
 */
public class ArticleReadPage extends BasePage {

    @FindBy(css = ".article-page>div.banner>div.container>h1")
    private WebElement titleArticleCreated;

    @FindBy(className = "article-content")
    private WebElement contentArticleCreated;

    @FindBy(linkText = "Edit Article")
    private WebElement linkEditArticle;

    @FindBy(xpath = "//*[@id='root']//span/button[contains(text(),'Delete Article')]")
    private WebElement linkDeleteArticle;

    @FindBy(css = ".article-page>div.banner>div.container")
    private WebElement alertMsg;

    @FindBy(css = "form.comment-form>div>textarea")
    private WebElement inputComments;

    @FindBy(css = "form.comment-form>div.card-footer>button")
    private WebElement buttonPostComment;

    @FindBy(css = ".card-text")
    private WebElement commentCard;

    @FindBy(css = " div.card-footer > a:nth-child(2)")
    private WebElement authorCommentCard;

    @FindBy(css = ".date-posted")
    private WebElement dateCommentCard;

    @FindBy(xpath = "//span[@class='mod-options']//i[@class='ion-trash-a']")
    private WebElement deleteCommentCard;

    public ArticleReadPage() {
        super();
    }

    public String getTitleArticle() {
        return getTextElement(titleArticleCreated);
    }

    public String getContentArticle() {
        return getTextElement(contentArticleCreated);
    }

    public void clickEditLink() {
        clickElement(linkEditArticle);
    }

    public void clickDeleteLink() {
        clickElement(linkDeleteArticle);
    }

    public String getAlertMsg() {
        return alertMsg.getText();
    }

    public void sendCommentArticle(String comment) {
        sendKeystoElement(inputComments, comment);
    }

    public void clickPostComment() {
        clickElement(buttonPostComment);
    }

    public String getCommentCard() {
        return getTextElement(commentCard);
    }

    public String getAuthorComment() {
        return getTextElement(authorCommentCard);
    }

    public String getDateComment() {
        return getTextElement(dateCommentCard);
    }

    public void clickDeleteCommentButton() {
        clickElement(deleteCommentCard);
    }

}
