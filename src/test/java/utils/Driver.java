package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static final String URL = System.getProperty("url",
            "https://trademarks.ipo.gov.uk/ipo-tmowner");
    private static final String BROWSERNAME = System.getProperty("browser", "firefox");
    public static String getUrl(){
        return URL;
    }
    public static WebDriver getBrowser(){
        ChromeOptions chromeOptions;
        switch (BROWSERNAME.toUpperCase()) {
            case ("CHROME_HEADLESS"):
                System.out.println(" Executing on CHROME HEADLESS");
                chromeOptions = new ChromeOptions();
// Set Chrome to run headlessly
                chromeOptions.addArguments("headless");
// Make sure the window size is large and maximised
// So nothing disappears off screen
// (even in headless mode!)
                chromeOptions.addArguments("window-size=1920,1080");
                chromeOptions.addArguments("start-maximized");
// Set up our ChromeDriver
                WebDriverManager.chromedriver().setup();
// Return the chromedriver with the chromeOptions set
                return new ChromeDriver(chromeOptions);

            case "CHROME":
// Tell the user which browser we're running our tests on
                System.out.println(" Executing on CHROME");
// Use `WebDriverManager` to setup our chromedriver
                WebDriverManager.chromedriver().setup();
// Return our Driver
                return new ChromeDriver();

            case "FIREFOX":
// Tell the user which browser we're running our tests on
                System.out.println(" Executing on FIREFOX");
// Use `WebDriverManager` to setup our firefoxdriver
                WebDriverManager.firefoxdriver().setup();
// Return our Driver
                return new FirefoxDriver();

            default:
                throw new IllegalArgumentException("The Browser Type is Undefined");


        }
    }
}