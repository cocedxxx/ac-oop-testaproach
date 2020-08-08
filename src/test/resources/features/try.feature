Feature: run test
  Scenario: run1
    Given I run script

  Scenario: API testing
#    Given I do API logging as "admin"
    When I do API registration a new "teacher"
#    And I do API delete "teacher"