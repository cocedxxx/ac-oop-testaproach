Feature: Registration
  Scenario: First name latin characters
    Given I open "registration" page
    When I type first name "Abc"
    And I type last name "Tests"
    And I type email "jggg@mail.ru" on registration page
    And I type group code "123"
    And I type password "12345" on registration page
    And I type confirm password "12345"
    And I click Register Me button
    Then Text "You have been Registered." appears

  Scenario: First name field is required
    Given I open "registration" page
    When I type first name ""
    And I type last name "Tests"
    And I type email "jg@mail.ru" on registration page
    And I type group code "123"
    And I type password "12345" on registration page
    And I type confirm password "12345"
    And I click Register Me button
    Then Text "This field is required" appears

  Scenario: First Name - min 1 char
    Given I open "registration" page
    When I type first name "A"
    And I type last name "Tests"
    And I type email "jg@mail.ru" on registration page
    And I type group code "123"
    And I type password "12345" on registration page
    And I type confirm password "12345"
    And I click Register Me button
    Then Text "You have been Registered." appears

  Scenario: First Name - Max 254 when last name 1
    Given I open "registration" page
    When I type first name "asfasfasfdasfdasdfasfdasfasfasfasfdasfdasdfasfdasfasfasfasfdasfdasdfasfdasfasfasfasfdasfdasdfasfdasfasfasfasfdasfdasdfasfdasfasfasfasfdasfdasdfasfdasfasfasfasfdasfdasdfasfdasfasfasfasfdasfdasdfasfdasfasfasfasfdasfdasdfasfdasfasfasfasfdasfdasdfasfdasfeeee"
    And I type last name "T"
    And I type email "jg@mail.ru" on registration page
    And I type group code "123"
    And I type password "12345" on registration page
    And I type confirm password "12345"
    And I click Register Me button
    Then Text "You have been Registered." appears

  Scenario: First Name - Whitespaces
    Given I open "registration" page
    When I type first name " Name"
    And I type last name "Test"
    And I type email "jg@mail.ru" on registration page
    And I type group code "123"
    And I type password "12345" on registration page
    And I type confirm password "12345"
    And I click Register Me button
    Then Text "Whitespaces not allowed" appears