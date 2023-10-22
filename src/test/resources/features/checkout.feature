Feature: Verify checkout functionally
  Background:
    Given User on the login state
    When User input username password
    And User tap login
    Then User success login

  Scenario: User want to cancel checkout
    Given User on checkout page
    When User click cancel
    Then User directed back to detail cart

  Scenario: User want to continue checkout
    Given User on checkout page
    When User input the form
    And User click continue
    Then User directed to overview page