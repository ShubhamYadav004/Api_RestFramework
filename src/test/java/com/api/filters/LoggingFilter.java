package com.api.filters;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.util.logging.Logger;

public class LoggingFilter implements Filter {
    private static final Logger logger = Logger.getLogger(LoggingFilter.class.getName());

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext context) {
        logRequest(requestSpec);
        Response response = context.next(requestSpec,responseSpec); // Here alL Request will be executed
        logResponse(response);
        return response; //test for the assertions
    }

    public void logRequest(FilterableRequestSpecification requestSpec){
        logger.info("BASE URI : " +requestSpec.getBaseUri());
        logger.info(("Request Header : " + requestSpec.getHeaders()));
        logger.info(("Request PayLoad : " + requestSpec.getBody()));

    }

    public  void logResponse(Response response){
        logger.info("STATUS CODE: " +response.getStatusCode());
        logger.info("Response Header : " + response.headers());
        logger.info("Response PayLoad : " + response.getBody().prettyPrint());
    }
}
