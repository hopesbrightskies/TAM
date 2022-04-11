Feature: Search

  Scenario Outline: Search and verify content
    Given Home page is open
    When I perform search for <product>
    Then Search results match <product>
    When I choose <number> product and Save name and price
    When I click the More button of <number> product
    Then Name and Price are correct on Product details page

    Examples:
      |product  | number |
      |shirt    | 1      |
