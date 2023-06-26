package com.amazon.steps;

import com.amazon.pages.HomePage;
import net.thucydides.core.annotations.Step;

public class HomePageSteps {
	private HomePage homePage;

	@Step
	public void launchApplication() {
		homePage.launchApplication();
	}

	@Step
	public void searchProduct(String searchKey) {
		homePage.productSearch(searchKey);
	}
}
