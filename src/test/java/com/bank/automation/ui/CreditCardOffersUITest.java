package com.bank.automation.ui;

import org.testng.annotations.Test;
import com.bank.automation.base.BaseTest;

public class CreditCardOffersUITest extends BaseTest {

    @Test
    public void openBankingDemoSite() {
        driver.get("https://demo.opencart.com");
    }
}
