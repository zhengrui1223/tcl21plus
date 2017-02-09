package com.movit.study.log4j;

import org.apache.log4j.Priority;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/2/9.
 */
public class LogDemo {
    private static Logger logger = LoggerFactory.getLogger(LogDemo.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("E:\\project\\tcl21plus\\tcl21plus-portal\\src\\main\\webapp\\WEB-INF\\log4j.properties");
        logger.debug("Start of the main() in TestLog4j");
        logger.info("Just testing a log message with priority set to INFO");
        logger.warn("Just testing a log message with priority set to WARN");
        logger.error("Just testing a log message with priority set to ERROR");
    }
}
