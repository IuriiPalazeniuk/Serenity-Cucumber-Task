package com.amazon.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		plugin = {"pretty:target/cucumber/cucumber.txt", 
				"html:target/cucumber/cucumber-html-report",
				"json:target/cucumber/cucumber.json"
				}
		,features= {"src/test/resources/features"}
		,glue = {"com.amazon.stepdefinition"}
		,monochrome = true
		,tags="@searchFeature"
		)
public class TestRunner {

}
