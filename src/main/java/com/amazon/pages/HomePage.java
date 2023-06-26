package com.amazon.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends PageObject {

    @FindBy(id = "twotabsearchtextbox")
    WebElementFacade searchInput;

    @FindBy(id = "nav-search-submit-button")
    WebElementFacade searchButton;

    public void productSearch(String searchKey) {
        searchInput.type(searchKey);
        searchButton.click();
    }

    public void launchApplication() {
        open();
        getDriver().manage().window().maximize();
    }
}
