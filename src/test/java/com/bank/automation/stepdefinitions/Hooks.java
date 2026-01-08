package com.bank.automation.stepdefinitions;

import com.bank.automation.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseTest {

    @Before("@ui")
    public void setUpUI() {
        initDriver();
    }

    @After("@ui")
    public void tearDownUI() {
        quitDriver();
    }
}
