package com.fnma.exceptions;

//To make a custom Exception, just extend whatever Exception type you're basing it off of
public class NotACookieException extends RuntimeException {

    //The constructor takes a string - this is the error message (AKA the stack trace) we'll see.
    public NotACookieException(String message) {
        super(message);
    }


}
