package com.bank.automation.api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class CreditCardOffersAPITest {

    @Test
    public void validatePremiumOffer() {

        given()
                .baseUri("http://localhost:8080")
                .queryParam("customerType", "PREMIUM")
                .when()
                .get("/api/offers")
                .then()
                .statusCode(200)
                .body("cardType", equalTo("Platinum"))
                .body("cashback", equalTo("5%"));
    }
}
