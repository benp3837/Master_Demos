package com.revature.aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//This is a custom annotation!
//We can use it to annotate any controller methods that are only accessible by admins

@Target(ElementType.METHOD)  //This annotation can only be applied to methods
@Retention(RetentionPolicy.RUNTIME)  //The annotation will be available at runtime
public @interface AdminOnly {

    /* No need for any fields etc.
    We'll use @AdminOnly over any method that should be accessed only by admins
    Check the second @Before advice in the AuthAspect to see how we handle it */

}
