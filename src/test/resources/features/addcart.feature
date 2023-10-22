Feature: Verify cart functionally
  Background:
    Given User on the login page
    When User input credential
    And User click login
    Then User successfully login

  Scenario: User add cart
    Given User on dashboard
    When User add cart button
    Then Display count cart

  Scenario: User want to detail cart
    Given User on dashboard
    When User click icon cart
    Then User directed to detail cart

  Scenario: User want to continue shooping
    Given User on detail cart
    When User click continue shopping
    Then User directed to dashboard

  Scenario: User want to checkout
    Given User on detail cart
    When User click checkout
    Then User directed to checkout page