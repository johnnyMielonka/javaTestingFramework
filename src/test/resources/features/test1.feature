@all @gui

Feature: test feature #1

  Background:
    Given Starting point

  Scenario Outline: Running scenario <sequence>
    When Continuation "<sequence>"
    Then Verify if first column equals second:
      | a      | a      |
      | <arg1> | <arg2> |
    Examples:
      | sequence | arg1 | arg2 |
      | 1        | a    | a    |
      | 2        | a    | b    |
      | 3        | B    | b    |

