package utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
    public static WebElement waitForElement(By locator, WebDriver browser){
// Maximum time to wait in seconds
        int WAIT = 60;
        try {
// Wait for the element to appear
            new WebDriverWait(browser, WAIT)
                    .until(ExpectedConditions
                            .numberOfElementsToBeMoreThan(locator, 0));
        } catch (TimeoutException e){
// If it times out, print out the error, take a screenshot and the fail the test
            e.printStackTrace();
            Screenshots.capturescreenshot(browser,
                    Screenshots.generateScreenShotFileName());
            Assert.fail("Timeout: The element couldn't be found in " + WAIT + "seconds!");
        } catch (Exception e){
// If any other errors occur, print out the error, take a screenshot and then fail the test
            e.printStackTrace();
            Screenshots.capturescreenshot(browser,
                    Screenshots.generateScreenShotFileName());
            Assert.fail("Something went wrong!");
        }
// If the element is found and no failures occur, return the element
        return browser.findElement(locator);
    }
}
