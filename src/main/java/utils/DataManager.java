package utils;

import dtos.Articles;
import dtos.Profile;
import io.cucumber.java.Scenario;

public class DataManager {

    private static DataManager dataManager;
    private Articles articles;
    private Profile profile;
    private static final ThreadLocal<Scenario> scenario = new ThreadLocal<>();

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

    /**
     * Gets scenario.
     *
     * @return the scenario
     */
    public static Scenario getScenario() {
        return scenario.get();
    }
    /**
     * Register.
     *
     * @param scenario the scenario
     */
    public static void register(Scenario scenario) {
        DataManager.scenario.set(scenario);
    }

    /**
     * remove.
     */
    public static void remove() {
        scenario.remove();
    }
}
