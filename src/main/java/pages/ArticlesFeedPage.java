package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the webelements of the login form
 */
public class ArticlesFeedPage extends BasePage {

    @FindBy(css = "div.article-preview>a>h1")
    private List<WebElement> listTitleArticle;

    public ArticlesFeedPage() {
        super();
    }

   public List<String> articlesTitles(){
        List<String> titles = new ArrayList<>();
       for (WebElement element:listTitleArticle) {
           titles.add(element.getText());
       }
       return titles;
   }

   public void clickSpecificTitleArticle(String title){
       for (WebElement element:listTitleArticle) {
           if(element.getText().equals(title)){
               clickElement(element);
               break;
           }
       }

   }
}
