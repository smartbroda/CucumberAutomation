package com.martynsmart;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ResultsPage;
import pages.SearchByOwnerPage;
import utils.Driver;
import utils.Screenshots;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;


public class Stepdefs {

    WebDriver browser;
    SearchByOwnerPage searchByOwnerPage;
    ResultsPage resultsPage;

    @Before
    public void setUp() {
// Get the driver for the browser (e.g. ChromeDriver)
        browser = Driver.getBrowser();
        searchByOwnerPage = new SearchByOwnerPage(browser);
        resultsPage = new ResultsPage(browser);
// Navigate to the URL of our webpage
        browser.navigate().to(Driver.getUrl());
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(Integer.parseInt(System.getProperty("sleep", "2000")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        browser.quit();
    }

    @Given("I navigate to Search by owner page")
    public void i_navigate_to_Search_by_owner_page() {
        System.out.println("You are on the 'Search by owner' page");

    }


    @Then("I validate details on Search by owner page")
    public void i_validate_details_on_Search_by_owner_page() {
        assertThat("Validation of title failed or title no displayed", searchByOwnerPage.checkSearchByOwnerMessage(),
                containsString("Search for a trade mark"));

    }

    @When("I search by entering postcode {string} on Search by owner page")
    public void i_search_by_entering_postcode_on_Search_by_owner_page(String postcode) {
        searchByOwnerPage.enterPostcode(postcode);
        searchByOwnerPage.clickSearchButton();
    }

    @Then("I click on result link to progress to results finders page")
    public void i_click_on_result_link_to_progress_to_results_finders_page() {
        System.out.println("You are on the 'Results' page");
        assertThat("Validation of title failed or title not displayed", resultsPage.checkResultsMessage(),
                containsString("Your search found 17 owners"));
        //resultsPage.resultLink();
        System.out.println("You are now on the 'Search results page");
        Screenshots.capturescreenshot(browser, "Results_Search" + Screenshots.generateScreenShotFileName());

    }



}



