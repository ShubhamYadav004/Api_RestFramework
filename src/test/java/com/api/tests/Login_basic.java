package com.api.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Login_basic {
    @Test(description="verify login is working or not")

        public void LoginTest(){

            Response response = given()  // To take response

                    .baseUri("http://64.227.160.186:8080")
                    .header("Content-Type","application/json")
                    .body("{\"username\":\"uday1234\",\"password\":\"uday12345\"}")
                    .post("/com/auth/login");

            System.out.println(response.asPrettyString());

            Assert.assertEquals(response.getStatusCode(),200);
        }
    }

