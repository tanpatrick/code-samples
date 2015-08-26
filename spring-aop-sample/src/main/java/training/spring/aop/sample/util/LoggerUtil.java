package training.spring.aop.sample.util;

import org.apache.log4j.Logger;

/**
 *
 * @author Patrick Tan
 */
public class LoggerUtil {

    private static final Logger LOGGER = Logger.getLogger(LoggerUtil.class);

    public static void logMessage(String message) {
        LOGGER.info(message);
    }
}
