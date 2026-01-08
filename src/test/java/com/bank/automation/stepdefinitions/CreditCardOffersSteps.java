package com.bank.automation.stepdefinitions;

import com.bank.automation.api.AuthAPITest;
import com.bank.automation.api.CreditCardOffersAPITest;
import com.bank.automation.ui.CreditCardOffersUITest;
import com.bank.automation.utils.ScenarioContext;

import io.cucumber.java.en.*;
import io.cucumber.java.After;

public class CreditCardOffersSteps {

    private String customerType;

    private AuthAPITest authApi = new AuthAPITest();
    private CreditCardOffersAPITest offersApi = new CreditCardOffersAPITest();
    private CreditCardOffersUITest uiTest = new CreditCardOffersUITest();

    @Given("customer type is {string}")
    public void customer_type_is(String type) {
        customerType = type;
        authApi.generateOAuthToken();   // OAuth happens once
    }

    @When("customer checks credit card offers via API")
    public void customer_checks_credit_card_offers() {
        offersApi.validatePremiumOffer(customerType);
    }

    @Then("customer opens offers page on UI")
    public void customer_opens_offers_page_on_ui() {
        uiTest.openOffersPageWithSession();
    }

    @After
    public void cleanup() {
        ScenarioContext.clear(); // VERY important
    }
}
