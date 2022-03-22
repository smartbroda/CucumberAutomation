package locators;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class ResultsLocators {

    private By resultsMessage = By.xpath("//h2[contains(text(),'Your search found')]");
    //private By searchLink1 = By.linkText("Start from the beginning");




}
