Feature: Cart

  Scenario Outline: Browse and add product to cart
    Given Home page is open
    When I select <category> and <subcategory> from the Menu
    And Click on Add to cart button <number> product
    Then Adding to Cart popup <message> is shown
    When I click Proceed to checkout
    Then Selected product is in the Cart

    Examples:
      | category | subcategory    | number | message                                          |
      | dresses  | casual dresses | 1      | Product successfully added to your shopping cart |
      | t-shirts | none           | 1      | Product successfully added to your shopping cart |


