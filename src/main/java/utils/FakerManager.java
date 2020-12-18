package utils;

import com.github.javafaker.Faker;

/**
 * Class for generating random data
 */
public class FakerManager {
    private static FakerManager instance;
    private Faker faker;

    private FakerManager() {
        this.faker = new Faker();
    }

    public static FakerManager getInstance() {
        if (instance == null) {
            instance = new FakerManager();
        }
        return instance;
    }

    public Faker getFaker() {
        return this.faker;
    }
}
