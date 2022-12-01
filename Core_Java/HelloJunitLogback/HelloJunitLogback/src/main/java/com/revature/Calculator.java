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
        try {
            int i = x / y; //if y == 0, this will throw an exception and be caught by the catch
            logger.info("divided numbers " + x + " and " + y);
            return i;
        } catch(ArithmeticException e){
            logger.warn("attempted to divide by zero!");
            return 0;
        }
    }

}
