package org.stockii.common;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogUtil {
	private static final Logger logger;
    
    static {
        logger = Logger.getLogger(LogUtil.class);
        logger.setLevel(Level.ALL);
    }
    
    public static void log(String info, Level level, Throwable ex) {
        logger.log(level, info, ex);
    }
    
    public static Logger getLogger() {
        return logger;
    }
}
