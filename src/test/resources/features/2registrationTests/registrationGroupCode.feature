Feature: Registration - Group code

  Scenario: Allowable characters: Alphanumeric
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "mail" into "email" field
    And I type "alphanumeric char" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then registration confirmation page is open

  Scenario: Allowable characters: Alphanumeric Special char
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "mail" into "email" field
    And I type "alphanumeric with special char" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then registration confirmation page is open

  Scenario: Group code field can’t be empty
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "mail" into "email" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then Message "This field is required" appears

  Scenario: Group Code- Min 1 character
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "mail" into "email" field
    And I type "one char" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then registration confirmation page is open

  Scenario: Group Code- Max 6 characters (max boundary)
    Given I open "registration" page
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "mail" into "email" field
    And I type "max 6 char" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then registration confirmation page is open

  Scenario: Group Code- Max 7 characters (max boundary)
    Given I open "registration" page
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "mail" into "email" field
    And I type "max 7 char" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then Message "Too long. Should be no more than 6 characters" appears

  Scenario: Group Code- white spaces are not allowed -- BUG PRESENT --
    Given I open "registration" page
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "mail" into "email" field
    And I type "whitespaces" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then Message "Whitespaces are not allowed" appears



















