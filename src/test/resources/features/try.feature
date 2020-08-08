Feature: run test
  Scenario: run1
    Given I run script

  Scenario: API testing
#    Given I do API loging as "teacher"
#    When I do API registration a new "student"
    And I do API delete "student"