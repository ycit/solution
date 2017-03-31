package com.ycit.log;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Created by xlch on 2017/2/9.
 */
public class Log4jTest {

    private static final Logger logger = LogManager.getLogger(Log4jTest.class);

    @Test
    public void hello() {
        logger.debug("debug level");
        logger.info("info level");
        logger.trace("trace level");
        logger.fatal("fatal level");
        logger.warn("warn level");
        logger.error("error level");
    }

}
