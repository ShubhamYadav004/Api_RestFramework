package com.api.tests;
import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class ForgotPasswordTest {
        @Test(description="verify Forgot Password API is working or not")
        public  void ForgotPasswordTest(){
            AuthService authService = new AuthService();
            Response response = authService.forgotPassword("testuser1678881235@yahoo.com");
            System.out.println(response.asPrettyString());

        }
    }

