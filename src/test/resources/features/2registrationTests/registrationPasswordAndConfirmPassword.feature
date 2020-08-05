Feature:Registration password/Confirm password ACJ-200

  Scenario: Registration - password/confirm password - alphanumeric and special characters ACJ-201
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "valid mail" into "email" field
    And I type "group code" into "group code" field
    And I type "alphanumeric and special char" into "password" field
    And I type "alphanumeric and special char" into "confirm password" field
    And I click Register Me button
    Then registration confirmation page is open

  Scenario: Registration - Password/Confirm password - Password field is required ACJ-248
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "valid mail" into "email" field
    And I type "group code" into "group code" field
    And I type "alphanumeric and special char" into "confirm password" field
    And I click Register Me button
    Then Message "This field is required" appears

  Scenario: Registration password/Confirm password - minimum 5 characters ACJ-250
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "valid mail" into "email" field
    And I type "group code" into "group code" field
    And I type "minimum 5 characters" into "password" field
    And I type "minimum 5 characters" into "confirm password" field
    And I click Register Me button
    Then registration confirmation page is open

  Scenario: Registration password/Confirm password - not allowed less then 5 characters ACJ-***
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "valid mail" into "email" field
    And I type "group code" into "group code" field
    And I type "less then 5 char" into "password" field
    And I type "less then 5 char" into "confirm password" field
    And I click Register Me button
    Then Message "Too short. Should be at least 5 characters" appears

  Scenario: Registration password/Confirm password - max 32 characters ACJ-252
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "valid mail" into "email" field
    And I type "group code" into "group code" field
    And I type "max 32 characters" into "password" field
    And I type "max 32 characters" into "confirm password" field
    And I click Register Me button
    Then registration confirmation page is open

  Scenario: Registration password/Confirm password - not allowed 33 characters --BUG--
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "valid mail" into "email" field
    And I type "group code" into "group code" field
    And I type "max 33 characters" into "password" field
    And I type "max 33 characters" into "confirm password" field
    And I click Register Me button
    Then Message "Too long. Should be no more than 32 characters" appears

  Scenario:  Registration - Password/Confirm password - whites spaces aren't allowed ACJ-290
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "valid mail" into "email" field
    And I type "group code" into "group code" field
    And I type "whitespaces" into "password" field
    And I type "whitespaces" into "confirm password" field
    And I click Register Me button
    Then Message "Whitespaces are not allowed" appears

  Scenario:  "Registration - Password/Confirm password" - password must match confirm password ACJ-292
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "valid mail" into "email" field
    And I type "group code" into "group code" field
    And I type "alphanumeric and special char" into "password" field
    And I type "minimum 5 characters" into "confirm password" field
    And I click Register Me button
    Then Message "Entered passwords should match" appears