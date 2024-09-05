package com.revature;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

//This service takes in an ____ object, and returns a String
public class Launcher implements RequestHandler<Object, String>{
    @Override
    public String handleRequest(Object o, Context context) {

        context.getLogger().log("Hello World! I'm in a Maven app running on Lambda");

        return "Hi from a Maven app running on Lambda!";
    }
}
