@registration
Feature: Registration - Last Name
  Scenario: Last Name allowable Latin characters.
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "latin characters" into "last name" field
    And I type "mail" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then registration confirmation page is open

  Scenario: Last Name field required, can’t be empty.
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "mail" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then Message "This field is required" appears

  Scenario: Max 254 characters (When the First name 1 char)
    Given I open "registration" page
    When I type "one char" into "first name" field
    And I type "254 max characters" into "last name" field
    And I type "mail" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then registration confirmation page is open

  Scenario: Verify Length 255 Is Invalid (When the First name 1 char)
    Given I open "registration" page
    When I type "one char" into "first name" field
    And I type "255 max characters" into "last name" field
    And I type "mail" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then Message "Data too long" appears on the bottom

  Scenario: Min 1 characters
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "one char" into "last name" field
    And I type "mail" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then registration confirmation page is open

  Scenario: Verify cannot contain white space
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name with space" into "last name" field
    And I type "mail" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then Message "Whitespaces are not allowed" appears
