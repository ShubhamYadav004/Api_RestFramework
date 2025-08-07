package com.api.tests;
import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class UpdateProfileTest {

        @Test (description="Check whether Profile update API is working or not")
        public  void UpdateProfileTest(){
            AuthService authService = new AuthService();
            Response response = authService.login(new LoginRequest("uday12345","uday1234"));
            LoginResponse loginResponse = response.as(LoginResponse.class);


            System.out.println("------------------------------------------------------------");
            UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
            response =userProfileManagementService.getProfile(loginResponse.getToken());
            System.out.println(response.asPrettyString());
            UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
            Assert.assertEquals(userProfileResponse.getUsername(),"uday1234");

            System.out.println("-------------------------------------------------------------");
            ProfileRequest profileRequest = new ProfileRequest.Builder()
                    .firstName("Alok")
                    .lastName("Yadav")
                    .email("ALOK1234@yahoo.com")
                    .mobileNumber("6666666666")
                    .build();

            response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
            System.out.println(response.asPrettyString());
            System.out.println("This is Status code after execution : "+response.getStatusCode());
        }
    }


