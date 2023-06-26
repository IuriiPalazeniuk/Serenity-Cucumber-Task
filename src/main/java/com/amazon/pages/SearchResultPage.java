package com.amazon.pages;

import lombok.SneakyThrows;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends BasePage {

    @FindBy(id = "low-price")
    WebElementFacade minPriceInput;
    @FindBy(id = "high-price")
    WebElementFacade maxPriceInput;
    @FindBy(xpath = "//span[contains(text(), 'Go')]/parent::span/input[@type='submit']")
    WebElementFacade goButton;
    @FindBy(xpath = "//span[contains(text(), 'Cell Phone Compatibility')]/parent::div/following-sibling::ul")
    WebElementFacade cellPhoneCompatibility;
    @FindBy(xpath = "//span[@class='a-price-whole']")
    List<WebElementFacade> productPrice;


    public void choosePriceRange(String minPrice, String maxPrice) {
        minPriceInput.type(minPrice);
        maxPriceInput.type(maxPrice);
        scrollToElement(goButton).click();
        waitForPageLoaded();
    }

    public void filterByPhoneCompatibility(String phoneCompatibility) {
        cellPhoneCompatibility.find(By.xpath(".//span[contains(text(), '" + phoneCompatibility + "')]")).click();
        waitForPageLoaded();
    }

    @SneakyThrows
    public void checkSearchedPrice(String minPrice, String maxPrice) {
//        boolean productHasPrice = false;
        Thread.sleep(1500); //added extra waiter to load all the results
//        List<SearchedProducts> products = getAllSearchedProducts(getDriver());
//        for(SearchedProducts product : products) {
//            if(!product.getCurrentPrice().isEmpty()) {
//                Assert.assertTrue(Integer.parseInt(product.getCurrentPrice()) > Integer.parseInt(minPrice) &
//                        Integer.parseInt(product.getCurrentPrice()) < Integer.parseInt(maxPrice));
//                productHasPrice = true;
//                break;
//            }
//        }
//        Assert.assertTrue("There is no product with expected price range!", productHasPrice);

        List<String> prices = productPrice.stream().map(p -> p.getText()).collect(Collectors.toList());
        prices.stream().forEach(p ->
                Assert.assertTrue(Integer.parseInt(p) > Integer.parseInt(minPrice) &
                Integer.parseInt(p) < Integer.parseInt(maxPrice)));

    }

}
