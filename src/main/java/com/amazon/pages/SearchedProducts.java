package com.amazon.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

//Wanted to parse the search result products but it's working with huge delay, must investigated why ((
@Getter
public class SearchedProducts {

    private static String resultsTable = "//div[contains(@cel_widget_id, 'MAIN-SEARCH_RESULTS')]";
    private static String description = ".//div[contains(@class, 's-title-instructions-style')]";
    private static String customerRate = ".//div[contains(@class, 'spacing-top-micro')]//span";
    private static String priceWithDiscount = ".//span[@class='a-price-whole']";
    private static String priceWithoutDiscount = ".//span[contains(@class, 'a-text-price')]//span";

    String productDescription;
    String customerRatings;
    String currentPrice;
    String previousPrice;

    public SearchedProducts(String productDescription, String customerRatings, String currentPrice, String previousPrice) {
        this.productDescription = productDescription;
        this.customerRatings = customerRatings;
        this.currentPrice = currentPrice;
        this.previousPrice = previousPrice;
    }

    public static SearchedProducts getSearchedProduct(WebElement result) {
        return new SearchedProducts(
                result.findElement(By.xpath(description)).getText(),
                checkSizeOfElements(result, customerRate) ? result.findElement(By.xpath(customerRate)).getAttribute("aria-label") : "",
                checkSizeOfElements(result, priceWithDiscount) ? result.findElement(By.xpath(priceWithDiscount)).getText() : "",
                checkSizeOfElements(result, priceWithoutDiscount) ? result.findElement(By.xpath(priceWithoutDiscount)).getText() : "");
    }

    private static boolean checkSizeOfElements(WebElement result, String locator) {
       return result.findElements(By.xpath(locator)).size() > 0;
    }

    public static List<SearchedProducts> getAllSearchedProducts(WebDriver driver) {
        List<SearchedProducts> listOfProducts = new ArrayList<>();
        List<WebElement> products = driver.findElements(By.xpath(resultsTable));
        for (WebElement product : products) {
            listOfProducts.add(getSearchedProduct(product));
        }
        return listOfProducts;
    }

}
