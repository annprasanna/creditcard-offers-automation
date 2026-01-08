Feature: Credit Card Offers Campaign

  @api
  Scenario: Premium customer receives Platinum card offer via API
    Given customer type is "PREMIUM"
    When customer checks credit card offers via API

  @ui
  Scenario: Customer accesses offers page using OAuth token
    Given customer type is "PREMIUM"
    Then customer opens offers page on UI
