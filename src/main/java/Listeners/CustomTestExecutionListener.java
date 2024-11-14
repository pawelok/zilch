package Listeners;

import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class CustomTestExecutionListener implements TestWatcher {

//    private final AppiumDriver driver;
//
//    public CustomTestExecutionListener(AppiumDriver driver) {
//        this.driver = driver;
//    }
//
//    @Override
//    public void testFailed(ExtensionContext context, Throwable cause) {
//        // On failure, take a screenshot
//        takeScreenshot(context.getDisplayName());
//    }
//
//    private void takeScreenshot(String testName) {
//        try {
//            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            String screenshotPath = "screenshots/" + testName + ".png";
//            File destFile = new File("screenshots");
//            destFile.mkdirs();
//            Files.copy(screenshot, destFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
