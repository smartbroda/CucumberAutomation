package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.openqa.selenium.io.FileHandler.copy;

public class Screenshots {

    public static String generateScreenShotFileName(){
// create filename
        return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new
                Date()) + ".png";
    }

    public static void capturescreenshot(WebDriver browser, String fileName)
    {
// Take screenshot
        File scrFile = ((TakesScreenshot)browser).getScreenshotAs
                (OutputType.FILE);
// Make sure that the 'screenshots' directory exists
        File file = new File("target/screenshots");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
// Copy file to filename and location we set before
        try {
            copy(scrFile, new File("target/screenshots/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
