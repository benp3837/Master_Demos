package com.revature.HelloSpringAOP.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.slf4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect //This Class is an ASPECT. We will handle all of our Logging in this one Class
public class LoggingAspect {

    //a Logger object that will only exist in this Aspect
    private static Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    //In an Aspect, methods are called ADVICES.
    //Each advice will be responsible for logging certain parts of the application

    /*This advice will create a log BEFORE any method found in the models package executes*/
    @Before("within(com.revature.HelloSpringAOP.models.*)")
    public void logModelMethods(JoinPoint jp){

        //getTarget() returns the class/object in question
        //getSignature() returns the method signature
        log.info(jp.getTarget() + " invoked " + jp.getSignature());

    }

    /*This advice will run AFTER successfully returning a value
    A pointcut is where advice WILL be executed
    In this case, the pointcut is any method called fight that returns a String and takes any parameters)
    the "returning" attribute is simply giving us access to the object that gets returned from fight()
      */
    @AfterReturning(pointcut="execution(String eat(..))", returning="returnedObject")
    public void logSuccessfulMethod(JoinPoint jp, Object returnedObject){
        //jp tracks whatever method we're injecting advice into
        //returnedObject lets us access the object returned by the method
        log.info(jp.getTarget() + " invoked " + jp.getSignature() + " returning " + returnedObject);
    }

    /*This advice will run AFTER and exception is THROWN in the specified pointcut*/
    @AfterThrowing(pointcut="execution(String eat(..))", throwing="thrownException")
    public void logException(JoinPoint jp, Exception thrownException){
        //jp tracks whatever method we're injecting advice into
        //thrownException lets us access the exception thrown by the method
        log.warn(jp.getTarget() + " invoked " + jp.getSignature() + " throwing " + thrownException);
    }

}
