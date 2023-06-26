package com.amazon.stepdefinition;

import com.amazon.steps.HomePageSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SearchProductStepDefinition {
    @Steps
    HomePageSteps homePageSteps;

    @Given("I am on the application")
    public void i_am_on_the_application() {
        homePageSteps.launchApplication();
    }


    @When("I search for products containing {string}")
    public void i_search_for_products_containing(String searchKey) {
        System.out.println("When: " + searchKey);
        homePageSteps.searchProduct(searchKey);
    }
}
