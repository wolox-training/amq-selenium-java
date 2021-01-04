package utils.screenshots;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.BrowserManagement;

public class Screenshots {

    private Screenshots() {
    }

    public static byte[] captureScreenShotWithTestStepName() {
        try {
            // down casting WebDriver to use getScreenshotAs method.
            TakesScreenshot ts = (TakesScreenshot) BrowserManagement.getDriver();
            // capturing screen shot as output type file
            return ts.getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            return new byte[0];
        }
    }

}
