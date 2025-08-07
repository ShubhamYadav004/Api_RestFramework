package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;

import java.util.HashMap;

public class AuthService extends  BaseService{
    private  static final String BASE_PATH = "/api/auth/";

    public Response login(LoginRequest payload){ // auth services have method of login
        return postRequest(payload , BASE_PATH+"login");
    }
    public Response signUp(SignUpRequest payload){ // auth services have method of login
        return postRequest(payload , BASE_PATH+"signup");
    }
    public Response forgotPassword(String emailAddress){ // auth services have method of login
        // We have to create key value
        HashMap<String,String> payload = new HashMap<String,String>();
        payload.put("email",emailAddress);
        return postRequest(payload , BASE_PATH+"forgot-password");
    }

}
