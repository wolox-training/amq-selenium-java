package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class contains the webelements of the login form
 */
public class ArticlesFeedPage extends BasePage {

    @FindBy(css = ".article-meta>div>a.author")
    private List<WebElement> listAuthorArticle;

    @FindBy(css = "div.article-preview>a>h1")
    private List<WebElement> listTitleArticle;

    @FindBy(css = "ul.pagination>li.page-item>a")
    private List<WebElement> listPagination;

    @FindBy(className = "article-preview")
    private WebElement articlePreview;

    public ArticlesFeedPage() {
        super();
    }

    public List<String> articlesTitles() {
        List<String> titles = new ArrayList<>();
        for (WebElement element : listTitleArticle) {
            titles.add(getTextElement(element));
        }
        return titles;
    }

    public List<WebElement> articlesTitlesWe(){
        return listTitleArticle;
    }

    public void clickSpecificTitleArticle(String title) {
        Optional<WebElement> webElementOptional = listTitleArticle.stream()
                .filter(item -> item.getText().equals(title))
                .findFirst();
        if( webElementOptional.isPresent() ) {
            clickElement(webElementOptional.get());
        }
    }

    public String clickArticleByAnotherUser(String currentUser){
        String author ="";
        boolean exists = false;
        int i = 0;
        while(!exists) {
            Optional<WebElement> webElementOptional = listAuthorArticle.stream().filter(ele->!ele.getText().equals(currentUser) ).findFirst();
            if( webElementOptional.isPresent()){
                author = getTextElement(webElementOptional.get());
                webElementOptional.get().click();
                exists = true;
            } else {
                i++;
                clickElement(listPagination.get(i));
                forceWait();
            }
        }
        return author;
    }

    public String getArticlePreviewText(){
        return getTextElement(articlePreview);
    }
}
