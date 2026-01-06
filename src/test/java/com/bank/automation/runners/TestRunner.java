package com.bank.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",                  // your feature folder
        glue = {"com.bank.automation.stepdefinitions"},           // matches your step definitions
        plugin = {"pretty", "junit:target/surefire-reports/CreditCardOffers.xml"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
