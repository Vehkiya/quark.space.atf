package common.logs;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggerFactory {

    public static Logger getLogger(Class clazz) {
        Logger logger = Logger.getLogger(clazz);
        logger.setLevel(Level.INFO);
        return logger;
    }

}
