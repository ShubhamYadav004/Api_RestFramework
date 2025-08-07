package com.api.tests;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Login_test {


        @Test(description="verify login is working or not")
        public void LoginTest(){
            given()
                    .baseUri("http://64.227.160.186:8080")
                    .header("Content-Type", "application/json")
                    .body("{\"username\":\"uday1234\",\"password\":\"uday12345\"}")
                    .when()
                    .post("/api/auth/login")
                    .then()
                    .statusCode(200); // this is basic code

        }
    }

