@all @gui @demo

Feature: Testing Aurora Commerce

  Background:
    Given Open Aurora web page

  @menubar
  Scenario: Checking availability of menu items
    Then Verify Menu Bar contains following items:
      | New In        |
      | Clothes       |
      | Demo Category |
      | Accessories   |
      | Jewellery     |
      | Shoes         |
      | Sale          |

  @menubar
  Scenario Outline: Checking accessibility of <itemName> Menu Bar item
    When Open "<itemName>" item from Menu Bar
    Then Verify page title is "<itemName>"
    Examples:
      | itemName      |
      | New In        |
      | Clothes       |
      | Demo Category |
      | Accessories   |
      | Jewellery     |
      | Shoes         |
      | Sale          |
      | failMe        |

  @login
  Scenario Outline: NEGATIVE - verify error popup for invalid user/password: <user> / <password>
    When Navigate to login page
    And Log in as "<user>" user and "<password>" password
    Then Verify if error popup is visible
    And Verify error popup exist with text:
    """
    Your email and password were not recognised, please try again
    """
    Examples:
      | user  | password |
      | 1     | a        |
      | a     | 1        |
      | admin | password |
