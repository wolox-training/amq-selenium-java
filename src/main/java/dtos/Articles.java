package dtos;

import java.util.ArrayList;
import java.util.List;

public class Articles {

    private String titleArticle = "";
    private List<String> titlesArticles = new ArrayList<>();
    private String aboutArticle = "";
    private String contentArticle = "";
    private String tagArticle = "";
    private String commentArticle = "";
    private int amountFavorites = 0;

    public String getTitleArticle() {
        return titleArticle;
    }

    public void setTitleArticle(String titleArticle) {
        this.titleArticle = titleArticle;
    }

    public String getAboutArticle() {
        return aboutArticle;
    }

    public void setAboutArticle(String aboutArticle) {
        this.aboutArticle = aboutArticle;
    }

    public String getContentArticle() {
        return contentArticle;
    }

    public void setContentArticle(String contentArticle) {
        this.contentArticle = contentArticle;
    }

    public String getTagArticle() {
        return tagArticle;
    }

    public void setTagArticle(String tagArticle) {
        this.tagArticle = tagArticle;
    }

    public String getCommentArticle() {
        return commentArticle;
    }

    public void setCommentArticle(String commentArticle) {
        this.commentArticle = commentArticle;
    }

    public int getAmountFavorites() {
        return amountFavorites;
    }

    public void setAmountFavorites(int amountFavorites) {
        this.amountFavorites = amountFavorites;
    }

    public List<String> getTitlesArticles() {
        return titlesArticles;
    }

    public void setTitlesArticles(List<String> titlesArticles) {
        this.titlesArticles = titlesArticles;
    }
}
