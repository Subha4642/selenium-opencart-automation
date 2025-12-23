Feature: Login functionality

  @smoke @critical
  Scenario: Login with valid credentials
    Given user navigates to login & signup page
    When user logs in with valid credentials
    Then user should be logged in successfully
    
  @smoke @critical
    Scenario: Register a new User
    Given user navigates to login & signup page
    When user provides credentials to signup
    Then user enter account details for signup
    And new user account got created