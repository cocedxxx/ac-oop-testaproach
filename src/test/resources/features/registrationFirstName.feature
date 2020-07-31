Feature: Registration first name
  Scenario: First name latin characters
    Given I open "registration" page
    When I type "latin characters" into "first name" field
    And I type "last name" into "last name" field
    And I type "mail" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then registration confirmation page is open

  Scenario: First name field is required
    Given I open "registration" page
    When I type "last name" into "last name" field
    And I type "mail" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then Message "This field is required" appears

  Scenario: First Name - min 1 char
    Given I open "registration" page
    When I type "one char" into "first name" field
    And I type "last name" into "last name" field
    And I type "mail" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then registration confirmation page is open

  Scenario: First Name - Max 254 when last name 1
    Given I open "registration" page
    When I type "254 max characters" into "first name" field
    And I type "one char" into "last name" field
    And I type "mail" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then registration confirmation page is open

  Scenario: First Name - Whitespaces
    Given I open "registration" page
    When I type "whitespaces" into "first name" field
    And I type "last name" into "last name" field
    And I type "mail" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then Message "Whitespaces are not allowed" appears