@TestSearch
Feature: Searching Products

  In order to find items that I would like to purchase
  As a potential buyer I want to be able to search for products
  by prices and phone capabilities

  @searchFeature
  Scenario: Searching the product using search functionality
    Given I am on the application
    When I search for products containing "Portable Charger"
    And I set price range from "20" to "50" dollars
    And I select "Apple iPhone" cell phone compatibility
    Then I should see at least one item with a price of "20" to "50"