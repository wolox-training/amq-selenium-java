package utils;

import dtos.Articles;
import dtos.Profile;

public class DataManager {

    private static DataManager dataManager;
    private Articles articles;
    private Profile profile;

    private DataManager() {    }

    public static DataManager getInstance(){
        if(dataManager==null){
            dataManager=new DataManager();
        }
        return dataManager;
    }

    public Articles getArticles() {
        return articles;
    }

    public void setArticles(Articles articles) {
        this.articles = articles;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
