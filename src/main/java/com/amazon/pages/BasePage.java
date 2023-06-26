package com.amazon.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;

import static net.serenitybdd.core.pages.WebElementExpectations.elementIsDisplayed;
import static net.serenitybdd.core.pages.WebElementExpectations.elementIsNotDisplayed;

public class BasePage extends PageObject {

    @FindBy(xpath = "//div[@class='a-spinner-wrapper']")
    WebElementFacade spinner;

    protected void waitForPageLoaded() {
        elementIsDisplayed(spinner);
        elementIsNotDisplayed(spinner);
    }

    protected WebElementFacade scrollToElement(WebElementFacade element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
        return element;
    }
}
