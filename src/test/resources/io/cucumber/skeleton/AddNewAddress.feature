Feature: Add Address

  Scenario Outline: Add new address
    Given I logged in and click on ADD FIRST ADDRESS
    When I enter "<alias>" as alias
    And I enter "<address>" as address
    And I enter "<city>" as city
    And I enter "<zip>" as zip
    And I enter "<country>" as country
    And I enter "<phone>" as phone
    And I check all of typed data are correct "<alias>", "<address>", "<city>", "<zip>", "<country>", "<phone>"
    And  I click SAVE button
    Then New address is added
#    And I deleted new address
    Examples:                   # value = 17 for country
      | alias | address | city   | zip    | country | phone     |
      | Mr    | Coders  | London | 09-400 | 17      | 123456789 |