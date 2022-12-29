package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {

    private static final Logger logger = LoggerFactory.getLogger(Calculator.class);
    public int add(int x, int y){
        logger.info("added numbers " + x + " and " + y);
        return x + y;
    }

    public int subtract(int x, int y){
        logger.info("subtracted numbers " + x + " and " + y);
        return x - y;
    }

    public int divide(int x, int y){
        if(y != 0) {
            int i = x / y; //if y == 0, this will throw an exception
            logger.info("divided numbers " + x + " and " + y);
            return i;
        } else {
            logger.warn("about to divide by zero!");
            return x / y; //this will throw an exception
            //normally I'd want a try/catch here, but I want to use this for testing
        }
    }

}
