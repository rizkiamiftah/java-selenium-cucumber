Feature: Verify login functionally
  Scenario: User successfully login
    Given User is on saucedemo login page
    When User input valid email
    And User input valid password
    And User click login button
    Then User success directed to dashboard page

    Scenario: Invalid Credentials
      Given User is on saucedemo login page
      When User input valid email
      And User input invalid password
      And User click login button
      Then Display invalid credential alert

    Scenario: Invalid Email
      Given User is on saucedemo login page
      When User input invalid email
      And User input valid password
      And User click login button
      Then Display invalid email alert

    Scenario: Empty Email Field
      Given User is on saucedemo login page
      When User input blank email
      And User input valid password
      And User click login button
      Then Display error blank email alert

    Scenario: Empty Password Field
      Given User is on saucedemo login page
      When User input valid email
      And User input blank password
      And User click login button
      Then Display error blank password alert