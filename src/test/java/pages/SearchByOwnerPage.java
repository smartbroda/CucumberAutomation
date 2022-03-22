package pages;

import locators.SearchByOwnerLocators;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;
import utils.Waits;

@RequiredArgsConstructor
public class SearchByOwnerPage {

    SearchByOwnerLocators sLocators = new SearchByOwnerLocators();

    @NonNull
    WebDriver browser;
//
//    public String getPageTitle()
//    {
//
//
//        return browser.getTitle();
//
//
//    }

    public String checkSearchByOwnerMessage(){
        return Waits.waitForElement(sLocators.getTitleMessageLocator(), browser).getText();
    }

    public void enterPostcode(String postcode){
        Waits.waitForElement(sLocators.getSearchFieldLocator(), browser).
                sendKeys(postcode);
    }

    public void clickSearchButton(){
        Waits.waitForElement(sLocators.getSearchButtonLocator(), browser).click();
    }
}
