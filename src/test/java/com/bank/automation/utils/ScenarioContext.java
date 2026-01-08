package com.bank.automation.utils;

public class ScenarioContext {

    private static ThreadLocal<String> accessToken = new ThreadLocal<>();

    public static void setAccessToken(String token) {
        accessToken.set(token);
    }

    public static String getAccessToken() {
        return accessToken.get();
    }

    public static void clear() {
        accessToken.remove();
    }
}
