package com.revature.aspects;

import com.revature.controllers.AuthController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthAspect {

    //Checks if the User is logged in (AuthController.session != null)
    @Before("execution(* com.revature.controllers.UserController.*(..)) && " +
            "!execution(* com.revature.controllers.UserController.registerUser(..))")
    public void checkLogin() throws IllegalArgumentException {

        if (AuthController.session == null) {
            //TODO: again, custom exception? no time for that now
            throw new IllegalArgumentException("User is not logged in.");

            /*NOTE: when thrown, the Exp doesn't get handled by the controller's handler
            ...since this happens before the controller is even invoked
            we could do a global exception handler, but no time (look into it if you want!)
            we'll handle for errors in the same way in the front end anyway.*/
        }

    }

    //Checks for admin privileges when invoking methods annotated with @AdminOnly.
    @Before("execution(* com.revature.controllers.UserController.*(..)) && " +
            "@annotation(com.revature.aspects.AdminOnly)")
    public void checkAdmin() throws IllegalArgumentException {

        System.out.println(AuthController.session.getAttribute("role"));
        System.out.println(!AuthController.session.getAttribute("role").equals("admin"));

        //If the logged in User's role isn't "admin", throw an Exception
        if (!AuthController.session.getAttribute("role").equals("admin")) {
            throw new IllegalArgumentException("User does not have admin privileges.");
        }

    }
}
