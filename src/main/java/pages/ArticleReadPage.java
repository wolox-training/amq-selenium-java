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

    public ArticleReadPage() {
        super();
    }

    public String getTitleArticle() {
        return getTextElement(titleArticleCreated);
    }

    public String getContentArticle() {
        return getTextElement(contentArticleCreated);
    }

    public void clickEditLink(){
        clickElement(linkEditArticle);
    }

    public void clickDeleteLink(){
        clickElement(linkDeleteArticle);
    }

    public String getAlertMsg(){
        return alertMsg.getText();
    }

    public void sendCommentArticle(String comment){
        sendKeystoElement(inputComments, comment);
    }

    public void clickPostComment(){
        clickElement(buttonPostComment);
    }

    public String getCommentCard(){
        return getTextElement(commentCard);
    }
}
