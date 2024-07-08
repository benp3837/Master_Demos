package com.revature;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Calculator {

    /* A better calculator would have more than just add and divide of course
     But this demo is mainly for examples of:
     1) unit testing with JUnit
     2) logging with Logback */

    //instantiate logger
    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    public int add(int a, int b) {
        log.info("Adding {} and {}", a, b);
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            log.warn("User tried to divide by zero... get a load of this guy hahahaha");
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        log.info("Dividing {} by {}", a, b);
        return a / b;
    }

}
