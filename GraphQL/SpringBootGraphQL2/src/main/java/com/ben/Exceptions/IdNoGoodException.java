package com.ben.Exceptions;

import graphql.GraphQLException;

public class IdNoGoodException extends GraphQLException {
    public IdNoGoodException(String message) {
        super(message);
    }
}
