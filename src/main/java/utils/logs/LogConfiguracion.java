package utils.logs;

import utils.reports.ReportLogHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Utility class for general configuration of Logs
 */
public class LogConfiguracion {

    /**
     * Instance (Singleton Pattern)
     */
    private static final LogConfiguracion instans = new LogConfiguracion();
    /**
     * Level used by default for loggers
     */
    private Level level;
    /**
     * Format class for logs
     */
    private Formatter formatrer;

    /**
     * Method that allows to initialize the elements of the LogConfiguracion class
     */
    private LogConfiguracion() {
        addCustomHandler();
        configure(Level.INFO, null, new SimpleFormatter());
    }

    /**
     * Method that allows obtaining the instance of the class
     *
     * @return The value of the instans attribute
     */
    public static LogConfiguracion getInstans() {
        return instans;
    }

    /**
     * Add the custom Handler to the logs.
     */
    private void addCustomHandler() {
        Logger logger = Logger.getLogger("");
        logger.addHandler(new ReportLogHandler());
    }

    /**
     * Loads the configuration of the logs from an input stream
     *
     * @param in Input flow for configuration
     * @throws SecurityException if a security manager exists and if the caller does not have
     *                           LoggingPermission("control").
     * @throws IOException       if there are problems reading from the stream, or the given stream
     *                           is not in the properties file format.
     */
    public void configureFromInput(InputStream in) throws IOException {
        LogManager.getLogManager().readConfiguration(in);
    }

    /**
     * Set the Level and path of a log file
     *
     * @param level Level to be used in {@link Logger}
     * @param path  Log file path
     */
    public void configure(Level level, String path) {
        configure(level);
        configure(path);
    }

    /**
     * Configure the Level, the path of a log file and the format to be used in the Logs
     *
     * @param level     Level to be used in  {@link Logger}
     * @param path      Log file path
     * @param formatter format to be used in the logs
     */
    public void configure(Level level, String path, Formatter formatter) {
        configure(level);
        configure(formatter);
        configure(path);
    }

    /**
     * Configure the format to be used in the Logs
     *
     * @param formatter format to be used in the logs
     */
    public void configure(Formatter formatter) {
        this.formatrer = formatter;
        Logger logger = Logger.getLogger("");
        for (Handler handler : logger.getHandlers()) {
            handler.setFormatter(formatter);
        }

    }

    /**
     * Set the path of a log file
     *
     * @param path Log file path
     */
    public void configure(String path) {
        Logger logger = Logger.getLogger("");
        for (Handler handler : logger.getHandlers()) {
            if (handler instanceof FileHandler) {
                logger.removeHandler(handler);
                handler.close();
            }
        }
        if (path != null) {
            try {
                FileHandler fileHandler = new FileHandler(path);
                fileHandler.setLevel(level);
                fileHandler.setFormatter(formatrer);
                logger.addHandler(fileHandler);
            } catch (SecurityException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Set the Level to be used in the Logs
     *
     * @param level Level to be used in {@link Logger}
     */
    public void configure(Level level) {
        this.level = level;
        Logger logger = Logger.getLogger("");
        logger.setLevel(level);
        for (Handler handler : logger.getHandlers()) {
            handler.setLevel(level);
        }
        Enumeration<String> enumeration = LogManager.getLogManager().getLoggerNames();
        while (enumeration.hasMoreElements()) {
            LogManager.getLogManager().getLogger(enumeration.nextElement()).setLevel(level);
        }
    }

}
