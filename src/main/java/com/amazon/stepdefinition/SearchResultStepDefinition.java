package com.amazon.stepdefinition;

import com.amazon.steps.SearchResultsPageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class SearchResultStepDefinition {

    @Steps
    SearchResultsPageSteps searchResultsPageSteps;

    @And("I set price range from {string} to {string} dollars")
    public void iSetPriceRangeFromToDollars(String minPrice, String maxPrice) {
        searchResultsPageSteps.searchForPriceRange(minPrice, maxPrice);
    }

    @And("I select {string} cell phone compatibility")
    public void iSelectCellPhoneCompatibility(String compatibility) {
        searchResultsPageSteps.filterByPhoneCompatibility(compatibility);
    }

    @Then("I should see at least one item with a price of {string} to {string}")
    public void iShouldSeeAtLeastOneItemWithAPriceOfTo(String minPrice, String maxPrice) {
        searchResultsPageSteps.checkPriceOfSearchedProducts(minPrice, maxPrice);
    }
}
