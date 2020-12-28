package dtos;

public class Articles {

    private String titleArticle = "";
    private String aboutArticle = "";
    private String contentArticle = "";
    private String tagArticle = "";
    private String commentArticle = "";

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
}
