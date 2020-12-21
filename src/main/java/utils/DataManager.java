package utils;

import dtos.Articles;

public class DataManager {

    private static DataManager dataManager;
    private Articles articles;

    private DataManager (){    }

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
}
