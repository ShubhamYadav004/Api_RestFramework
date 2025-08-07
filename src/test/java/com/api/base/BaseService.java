package com.api.base;

import com.api.filters.LoggingFilter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseService {
    //base uri
    // creating the request
    // Handling the response --This is wrapper for Test class and use abstraction

    private  static final String BASE_URL = "http://64.227.160.186:8080"; // Here we created on static and final base url
    private RequestSpecification requestSpecification;  // this is instance varaible AND THIS IS INTERFACE

    static {
        RestAssured.filters(new LoggingFilter());   // ONE TIME SETUP dont put in constructor because in parallel testing that will run again and again
    }


    protected  void  setAuthToken(String token){
        requestSpecification.header("Authorization" , "Bearer " + token);
    }

    public BaseService(){    // default constructor - and it's job is inetilaizing instance variable

        requestSpecification = given().baseUri(BASE_URL); //here request specification is same and i use same given in place of base uri i gave that BASE_URL
    }
    protected Response postRequest(Object payload, String endpoint){  // Gave 2 - payload and endpoints
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }
    protected Response getRequest(String endpoint){  // No Payload in Get Request
        return requestSpecification.get(endpoint);
    }
    protected Response putRequest(Object payload, String endpoint){  // In post and Put same thing will be use we give same thing just endpoint will be changed
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
    }
}
