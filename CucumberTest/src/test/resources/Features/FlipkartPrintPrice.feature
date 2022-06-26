Feature: Print the price of a phone on flipkart

  @Flipkart
  Scenario: Open flipkart home page and add a phone to cart
    Given user launch browser
    When user navigates to flipkart homepage
    And searches for a mobile device
    And adds mobile to cart increasing the quantity by one
    Then user can see updated price of two smartphones
