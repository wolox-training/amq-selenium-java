package dtos;

public class Articles {

    private static String titleArticle = "";
    private static String aboutArticle = "";
    private static String contentArticle = "";
    private static String tagArticle = "";

    public static String getTitleArticle() {
        return titleArticle;
    }

    public static void setTitleArticle(String titleArticle) {
        Articles.titleArticle = titleArticle;
    }

    public static String getAboutArticle() {
        return aboutArticle;
    }

    public static void setAboutArticle(String aboutArticle) {
        Articles.aboutArticle = aboutArticle;
    }

    public static String getContentArticle() {
        return contentArticle;
    }

    public static void setContentArticle(String contentArticle) {
        Articles.contentArticle = contentArticle;
    }

    public static String getTagArticle() {
        return tagArticle;
    }

    public static void setTagArticle(String tagArticle) {
        Articles.tagArticle = tagArticle;
    }
}
