@registration
Feature: Registration - Email

  Scenario: ACJ-161.Registration - Email - valid email format
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "valid mail" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then registration confirmation page is open

  Scenario: ACJ-162.Registration - Email - Required field
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then Message "This field is required" appears


  Scenario: ACJ-163.Registration - Email - max char(64) in Local part of email
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "email max char 64" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then registration confirmation page is open

  Scenario: ACJ-164.Registration - Email - max char (65) in Local part of email
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "email max char 65" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then Message "Should be a valid email address" appears

  Scenario: ACJ-165.Registration - Email - max char (63) in Domain server part
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "email max char 63 for sever domain" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then registration confirmation page is open

  Scenario: ACJ-166.Registration - Email - max char (64) Domain server part
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "email max char 64 for server domain" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then Message "Should be a valid email address" appears

  Scenario: ACJ-168.Registration - Email - max char (63) in Domain part
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "email max char 63 for domain" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then registration confirmation page is open

  Scenario: ACJ-169.Registration - Email - max char (64) in Domain part
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "email max char 64 for domain" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then Message "Should be a valid email address" appears

  Scenario: ACJ-170.Registration - Email - White spaces
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "whitespaces" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then Message "Should be a valid email address" appears

  Scenario: ACJ-171.Registration - Email - Missing @ character
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "email without @" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then Message "Should be a valid email address" appears

  Scenario: ACJ-172.Registration - Email - Missing "." character BUG present
    Given I open "registration" page
    When I type "first name" into "first name" field
    And I type "last name" into "last name" field
    And I type "email without dot" into "email" field
    And I type "group code" into "group code" field
    And I type "valid password" into "password" field
    And I type "valid password" into "confirm password" field
    And I click Register Me button
    Then Message "Should be a valid email address" appears

