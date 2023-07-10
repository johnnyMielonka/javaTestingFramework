@all
Feature: test feature

  Background:
    Given Starting point

  Scenario Outline: Running scenario 1
    When Continuation "<sequence>"
    Then Finish
    Examples:
    |sequence|
      |1  |
      |2  |
      |3  |
      |4  |

