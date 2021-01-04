package utils.reports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import utils.screenshots.Screenshots;

public class LoggerReport {

    private ExtentTest extentTest;

    public LoggerReport(ExtentTest extentTest) {
        this.extentTest = extentTest;
    }

    private Media createMedia(boolean screenShot) {
        if (screenShot) {
            return createMedia();
        }
        return null;
    }

    private Media createMedia() {
        return Report.getReportThreadLocal()
            .createMediaImage(Screenshots.captureScreenShotWithTestStepName());
    }

    public void log(Status status, String details, Throwable t, boolean screenShot) {
        extentTest.log(status, details, t, createMedia(screenShot));
    }

    public void log(Status status, String details) {
        extentTest.log(status, details);
    }

    public void log(Status status, String details, boolean screenShot) {
        if (screenShot) {
            extentTest.log(status, details, createMedia());
        } else {
            extentTest.log(status, details);
        }
    }

    public void log(Status status, Throwable t) {
        extentTest.log(status, t);
    }

    public void log(Status status, Throwable t, boolean screenShot) {
        if (screenShot) {
            extentTest.log(status, t, createMedia());
        } else {
            extentTest.log(status, t);
        }
    }

    public void info(String details) {
        extentTest.info(details);
    }

    public void info(String details, boolean screenShot) {
        if (screenShot) {
            extentTest.info(details, createMedia());
        } else {
            extentTest.info(details);
        }
    }

    public void pass(String details) {
        extentTest.pass(details);
    }

    public void pass(String details, boolean screenShot) {
        if (screenShot) {
            extentTest.pass(details, createMedia());
        } else {
            extentTest.pass(details);
        }
    }

    public void fail(String details) {
        extentTest.fail(details);
    }

    public void fail(String details, boolean screenShot) {
        if (screenShot) {
            extentTest.fail(details, createMedia());
        } else {
            extentTest.fail(details);
        }
    }

    public void fail(Throwable t) {
        extentTest.fail(t);
    }

    public void fail(Throwable t, boolean screenShot) {
        if (screenShot) {
            extentTest.fail(t, createMedia());
        } else {
            extentTest.fail(t);
        }
    }

    public void fail(String details, Throwable t) {
        log(Status.FAIL, details, t, false);
    }

    public void fail(String details, Throwable t, boolean screenShot) {
        log(Status.FAIL, details, t, screenShot);
    }

    public void warning(String details) {
        extentTest.warning(details);
    }

    public void warning(String details, boolean screenShot) {
        if (screenShot) {
            extentTest.warning(details, createMedia());
        } else {
            extentTest.warning(details);
        }
    }
}
