package com.api.tests;
import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

    @Listeners({com.api.listeners.TestListners.class,com.api.listeners.ExtentReportListener.class})
    public class LoginTest3 extends BaseTest{

        @Test(description="verify login is working or not")
        public  void loginTest (){
            AuthService authService = new AuthService();
            LoginRequest loginrequest = new LoginRequest("uday12345","uday1234");
            Response response= authService.login(loginrequest);
            LoginResponse loginResponse = response.as(LoginResponse.class);
            Assert.assertEquals(response.getStatusCode(),200);

            System.out.println( "This is Token : "+ loginResponse.getToken());
            System.out.println( "This is Email : "+ loginResponse.getEmail());
            System.out.println( "And Id is  : "+ loginResponse.getId());
            Assert.assertEquals(loginResponse.getEmail(),"ALOK1234@yahoo.com");

        }

    }

