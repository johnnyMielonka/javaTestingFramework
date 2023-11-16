@all @api
Feature: Scenarios feature file #2

  Scenario: Scenario Number One
    Given Starting point API
    And Web Api get call
    When Print response body
    Then Verify response code is 200


  Scenario: Negative Scenario Number One
    Given Starting point API
    And Web Api get call
    When Print response body
    Then Verify response code is 400