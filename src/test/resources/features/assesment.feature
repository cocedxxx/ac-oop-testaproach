@ac
Feature: Registration - First name

  @ac1
  Scenario: Registration - First name - Alphanumeric & Special characters
    Given Navigate to "registration" page
    Then Fill out form
    When Click "Register me" button
    Then "You have been Registered." message appears
