package com.bank.automation.stepdefinitions;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.cucumber.java.en.*;

public class CreditCardOffersSteps {

    private String customerType;

    @Given("customer type is {string}")
    public void customer_type_is(String type) {
        customerType = type;
    }

    @When("customer checks credit card offers")
    public void customer_checks_credit_card_offers() {

        given()
                .baseUri("http://localhost:8080")
                .queryParam("customerType", customerType)
                .when()
                .get("/api/offers")
                .then()
                .statusCode(200);
    }

    @Then("Platinum card offer should be returned")
    public void platinum_card_offer_should_be_returned() {

        given()
                .baseUri("http://localhost:8080")
                .queryParam("customerType", customerType)
                .when()
                .get("/api/offers")
                .then()
                .body("cardType", equalTo("Platinum"));
    }
}
