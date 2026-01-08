package com.bank.automation.api;

import static io.restassured.RestAssured.*;

import com.bank.automation.utils.ScenarioContext;

public class AuthAPITest {

    public void generateOAuthToken() {

        String token =
                given()
                        .baseUri("http://localhost:8080")
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("grant_type", "client_credentials")
                        .formParam("client_id", "bank-client-id")
                        .formParam("client_secret", "bank-client-secret")
                        .when()
                        .post("/oauth/token")
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("access_token");

        ScenarioContext.setAccessToken(token);
    }
}
