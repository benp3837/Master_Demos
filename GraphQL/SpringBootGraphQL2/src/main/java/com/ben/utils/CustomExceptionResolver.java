package com.ben.utils;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class CustomExceptionResolver extends DataFetcherExceptionResolverAdapter {


    public GraphQLError resolveToSingleError(Throwable ex) {
        if (ex instanceof NoSuchElementException) {
            return GraphqlErrorBuilder.newError()
                    .errorType(ErrorType.NOT_FOUND)
                    .message(ex.getMessage())
                    .build();
        } else {
            return null;
        }
    }
}
