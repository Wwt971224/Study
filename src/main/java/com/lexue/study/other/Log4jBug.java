package com.lexue.study.other;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jBug {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        String name = "${java:vm}";
        LOGGER.info("Hello,{}", name);
    }

}
