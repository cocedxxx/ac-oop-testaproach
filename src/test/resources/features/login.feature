Feature: Login
  Scenario: Login valid email, valid password
    Given I open "login" page
    When I type "valid mail" into email field
    And I type "valid password" into password field
    And I click Sign in button
    Then page contain "user Information"

  Scenario: Login invalid email, valid password
    Given I open "login" page
    When I type "invalid mail" into email field
    And I type "valid password" into password field
    And I click Sign in button
    Then page contain "authentication failed message"

  Scenario: Login invalid format email
    Given I open "login" page
    When I type "invalid mail format" into email field
    And I type "valid password" into password field
    Then page contain "Should be a valid email address error message"

  Scenario: Login empty email field
    Given I open "login" page
    And I type "valid password" into password field
    And I click Sign in button
    Then page contain "Email field is required message"

  Scenario: Login empty password field
    Given I open "login" page
    When I type "valid mail" into email field
    And I click Sign in button
    Then page contain "Password field is required message"

  Scenario:  Login email leading spaces not allowed
    Given I open "login" page
    When I type "email with leading space" into email field
    And I type "valid password" into password field
    And I click Sign in button
    Then page contain "Should be a valid email address error message"

  Scenario:  Login email trailing spaces not allowed
    Given I open "login" page
    When I type "email with trailing space" into email field
    And I type "valid password" into password field
    And I click Sign in button
    Then page contain "Should be a valid email address error message"

  Scenario: Password displays in bullets, copy, cut options disabled
    Given I open "login" page
    And I type "valid password" into password field
    Then page contain "password mask"

  Scenario:  Login password trailing spaces not allowed
    Given I open "login" page
    When I type "valid mail" into email field
    And I type "password with trailing space" into password field
    And I click Sign in button
    Then page contain "Whitespaces are not allowed error message"

  Scenario:  Login password leading spaces not allowed
    Given I open "login" page
    When I type "valid mail" into email field
    And I type "password with leading space" into password field
    And I click Sign in button
    Then page contain "Whitespaces are not allowed error message"
