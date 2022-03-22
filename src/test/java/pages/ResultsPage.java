package pages;

import locators.ResultsLocators;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;
import utils.Waits;

@RequiredArgsConstructor
public class ResultsPage {


    ResultsLocators rLocators = new ResultsLocators();

    @NonNull
    WebDriver browser;

    public String checkResultsMessage() {
        return Waits.waitForElement(rLocators.getResultsMessage(), browser).getText();
    }

//    public void resultLink() {
//        Waits.waitForElement(rLocators.getSearchLink1(), browser).click();
//    }

}
