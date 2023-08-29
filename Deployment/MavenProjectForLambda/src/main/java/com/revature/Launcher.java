package com.revature;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Launcher implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        return "Hello from Lambda!";
    }

}
