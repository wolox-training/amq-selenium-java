package utils.reports;

import com.aventstack.extentreports.Status;
import utils.DataManager;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class ReportLogHandler extends Handler {

    @Override
    public void publish(LogRecord record) {
        if (DataManager.getScenario() != null) {
            Status status = getStatus(record);
            Throwable throwable = record.getThrown();
            boolean screnShot = throwable != null || status != Status.INFO;
            if (throwable != null) {
                Report.logger().log(status, record.getMessage(), throwable, true);
            } else {
                Report.logger().log(status, record.getMessage(), screnShot);
            }
        }
    }

    private Status getStatus(LogRecord record) {
        Status status;
        if (record.getLevel().equals(Level.SEVERE)) {
            status = Status.FAIL;
        } else if (record.getLevel().equals(Level.WARNING)) {
            status = Status.WARNING;
        } else {
            status = Status.INFO;
        }
        return status;
    }

    /**
     * This is an implementation method
     */
    @Override
    public void flush() {
        //This is an implementation method
    }

    /**
     * This is an implementation method
     */
    @Override
    public void close() throws SecurityException {
        //This is an implementation method
    }
}
