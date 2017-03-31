package com.ycit.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xlch on 2017/2/9.
 */
public class Log4j2Slf4j {

    private static final Logger logger = LoggerFactory.getLogger(Log4j2Slf4j.class);

    @Test
    public void log() {
        logger.error("error");
        logger.debug("debug");
        logger.info("info");
        logger.trace("trace");
        logger.warn("warn");
        logger.error("error {}", "param");
    }

}
