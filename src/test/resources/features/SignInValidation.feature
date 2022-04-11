Feature: Sign in

  Scenario Outline: Sign in validation - Case 1-3
    Given Home page is open
    When I click on Sign in link
    And fill <email> into Email field
    And fill <password> into Password field
    And click on Sign in button
    Then The validation <message> is displayed

    Examples:
    |email            | password | message                   |
    |empty            | empty    |An email address required. |
    |hope@            | empty    |Invalid email address.     |
    |hope@example.com | password |Authentication failed.     |


