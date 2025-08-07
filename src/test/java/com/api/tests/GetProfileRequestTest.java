package com.api.tests;
import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

    public class GetProfileRequestTest {

        @Test (description = "check whether get profile API is working or not")
        public  void getProfileInfoTest(){
            AuthService authService = new AuthService();
            Response response = authService.login(new LoginRequest("uday12345","uday1234"));
            LoginResponse loginResponse =  response.as(LoginResponse.class);
            System.out.println(loginResponse.getToken());

            UserProfileManagementService  userProfileManagementService = new UserProfileManagementService();
            response = userProfileManagementService.getProfile(loginResponse.getToken());
            UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
            System.out.println(userProfileResponse.getUsername());
       
        }
    }


