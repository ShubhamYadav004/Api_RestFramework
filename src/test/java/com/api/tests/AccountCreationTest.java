package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class AccountCreationTest {
        @Test(description="verify Create Account is working or not")
        public  void createAccountTset(){

            SignUpRequest signUpRequest = new SignUpRequest.Builder()

                    .userName("Anup123458")
                    .email("anup216788812356@yahoo.com")
                    .firstName("Anup")
                    .lastName("singh")
                    .password("anup123458")
                    .mobileNumber("8130855323")
                    .build(); // what build method do - signup request

            AuthService authService = new AuthService();
            Response response = authService.signUp(signUpRequest);
            System.out.println(response.asPrettyString());
            System.out.println( "This status code : "+ response.getStatusCode());
            Assert.assertEquals(response.statusCode(),200);

        }
    }


