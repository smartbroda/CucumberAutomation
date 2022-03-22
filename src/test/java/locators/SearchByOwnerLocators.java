package locators;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class SearchByOwnerLocators {

    private By titleMessageLocator = By.xpath(".//h1[@class='heading-xlarge']");
    private By searchFieldLocator = By.xpath(".//input[@name='postCode']");
    private By searchButtonLocator = By.id("button");
}
