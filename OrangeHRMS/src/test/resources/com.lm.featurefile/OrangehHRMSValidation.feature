Feature: To validate the Login functionality of the OrangeHRMS
  Scenario: To validate the login page
    Given User navigates to the URL
    When User enters the valid Username and Password
    And User clicks the Login Button
    Then User should verify logged in successfully