Feature: Verify dashboard functionally
  Background:
    Given User on the saucedemo login page
    When User input valid credentials
    And User click the login
    Then User should be logged in successfully

  Scenario: User click cart
    Given User on dashboard page
    When User click cart
    Then User should be directed to cart page

  Scenario: User sort the product
    Given User on dashboard page
    When User sort name product z to a
    Then Display the list of product

  Scenario: User click title product
    Given User on dashboard page
    When User click title product
    Then User should be directed to detail product

  Scenario: User click image product
    Given User on dashboard page
    When User click image product
    Then User should to detail product

  Scenario: User want to logout
    Given User on dashboard page
    When User click sidebar menu
    And User click logout
    Then User success logout