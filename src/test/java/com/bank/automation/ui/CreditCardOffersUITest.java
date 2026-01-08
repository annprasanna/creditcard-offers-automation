package com.bank.automation.ui;

import com.bank.automation.base.BaseTest;
import com.bank.automation.utils.ScenarioContext;

public class CreditCardOffersUITest extends BaseTest {

    public void openOffersPageWithSession() {

        String token = ScenarioContext.getAccessToken();

        getDriver().get("https://demo.opencart.com?access_token=" + token);
    }
}
