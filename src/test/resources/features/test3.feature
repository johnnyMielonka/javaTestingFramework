@all @gui
Feature: Scenario Outlines feature file #3

  Scenario Outline: <scen_out_row_num>
    Given Step from "<scen_out_row_num>" in "scenario-outlines" feature file
    When Save "<scen_out_row_num>" to context TEMP
    Then Verify if context TEMP has "<scen_out_row_num>" value
    Examples:
      | scen_out_row_num       |
      | Scenario Outline Row 1 |
      | Scenario Outline Row 2 |