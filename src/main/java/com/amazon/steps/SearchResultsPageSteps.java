package com.amazon.steps;

import com.amazon.pages.SearchResultPage;
import net.thucydides.core.annotations.Step;

public class SearchResultsPageSteps {
	private SearchResultPage searchResultPage;

	@Step
	public void searchForPriceRange(String minPrice, String maxPrice) {
		searchResultPage.choosePriceRange(minPrice, maxPrice);
	}

	@Step
	public void filterByPhoneCompatibility(String phoneCompatibility) {
		searchResultPage.filterByPhoneCompatibility(phoneCompatibility);
	}

	@Step
	public void checkPriceOfSearchedProducts(String minPrice, String maxPrice) {
		searchResultPage.checkSearchedPrice(minPrice, maxPrice);
	}
}
