package com.revature.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.models.Avenger;

//This class is where we will handle all of our Logging functionality. 
//So much cleaner to put this all in one place!
@Component
@Aspect
public class LoggingAspect {

	private static Logger log = LogManager.getLogger(LoggingAspect.class);
	
	@Before("within(com.revature.models.*)")
	public void logModelMethods(JoinPoint jp) { //A joinpoint is where an advice COULD be injected. in this case models.
		//getTarget returns the object getting called, getSignature gets the method signature
		log.info(jp.getTarget() + " invoked " + jp.getSignature());
	}
	  
	//a pointcut is where advice WILL be injected. in this case the method called fight() that returns a String
	//the returning attribute? it's simply giving us access to the returned object from the method (a String)
	@AfterReturning(pointcut="execution(String fight(..))", returning="returnedObject")
	public void logFight(JoinPoint jp, Object returnedObject) {
		log.info(jp.getTarget()+" invoked "+jp.getSignature()+" returning "+returnedObject);
	}
	
	
	@AfterThrowing(pointcut="execution(String fight(..))", throwing="ex")
	public void logFightException(JoinPoint jp, Exception ex) {
		log.warn(jp.getTarget()+" invoked "+jp.getSignature()+" throwing "+ex.getClass(), ex);
	}
	
	//@Around is the most complicated, but most powerful Annotation in AOP
	@Around("execution(String fight(..))")
	public String logException(ProceedingJoinPoint pjp) throws Throwable {
		Avenger a = (Avenger) pjp.getArgs()[0];
		log.info(a.getAveName()+" is about to throw down!");
		double distance = (double) pjp.getArgs()[2];
		if(distance<6) {
			log.warn(a.getAveName()+" got too close!!! I can't let you get close. I'll throw an Exception");
			return "Looks like an exception got thrown...";
		}else {
			String s = (String) pjp.proceed();//this will actually allow the fight method to run. 
			log.info("I am happening after the fight");
			return s;
		}
	}

	
	
}