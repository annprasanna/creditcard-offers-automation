Feature: Credit Card Offers Campaign

  Scenario: Premium customer receives Platinum card offer
    Given customer type is "PREMIUM"
    When customer checks credit card offers
    Then Platinum card offer should be returned
