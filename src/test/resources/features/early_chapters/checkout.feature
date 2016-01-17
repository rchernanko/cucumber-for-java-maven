Feature: Checkout

  Scenario Outline: Checkout bananas
    Given the price of a "banana" is 40c
    When I checkout <count> "banana"
    Then the total price should be <total>c

    Examples:
      | count | total |
      | 1     | 40    |
      | 2     | 80    |

  Scenario Outline: Two bananas scanned separately
    Given the price of a "banana" is 40c
    When I checkout <count> "banana"
    And I checkout <count> "banana"
    Then the total price should be <total>c

    Examples:
      | count | total |
      | 1     | 80    |

  Scenario Outline: A banana and an apple
    Given the price of a "banana" is 40c
    And the price of a "apple" is 25c
    When I checkout <count> "banana"
    And I checkout <count> "apple"
    Then the total price should be <total>c

    Examples:
      | count | total |
      | 1     | 65    |