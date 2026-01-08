package com.bank.automation.api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.bank.automation.utils.DBUtil;
import com.bank.automation.utils.ScenarioContext;

public class CreditCardOffersAPITest {

    public void validatePremiumOffer(String eligibility) {

        String token = ScenarioContext.getAccessToken();

        // API call
        String apiCardType =
                given()
                        .baseUri("http://localhost:8080")
                        .auth().oauth2(token)
                        .queryParam("customerType", eligibility)
                        .when()
                        .get("/api/offers")
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("cardType");

        // DB call
        String dbCardType = DBUtil.getCardTypeByEligibility(eligibility);

        // Validation
        if (!apiCardType.equals(dbCardType)) {
            throw new AssertionError(
                    "Mismatch between API and DB. API=" + apiCardType +
                            ", DB=" + dbCardType);
        }
    }
}
