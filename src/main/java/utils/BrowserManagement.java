package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserManagement {

    private static WebDriver driver;
    private static Dotenv dotenv= Dotenv.load();

    private BrowserManagement() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = initializeDriver();
        }
        return driver;
    }

    public static WebDriver initializeDriver() {
        switch (dotenv.get("BROWSER")) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--incognito");
                desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                driver = new ChromeDriver(chromeOptions);
                break;
            default:
                break;
        }
        return driver;
    }
}
