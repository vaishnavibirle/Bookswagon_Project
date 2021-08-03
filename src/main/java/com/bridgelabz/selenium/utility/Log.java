package com.bridgelabz.selenium.utility;

import com.bridgelabz.selenium.base.BaseClass;
import io.qameta.allure.Feature;
import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Feature("Log class")
@Description("Created log class for using methods of logger" +
        "Called each method by giving parameter as string message")
public class Log extends BaseClass {
    private static final Logger log =  LogManager.getLogger(Log.class.getName());
    public static void info (String message) {
        log.info(message);
    }
    public static void warn (String message) {
        log.warn(message);
    }
    public static void error (String message) {
        log.error(message);
    }
    public static void fatal (String message) {
        log.fatal(message);
    }
    public static void debug (String message) {
        log.debug(message);
    }

}
