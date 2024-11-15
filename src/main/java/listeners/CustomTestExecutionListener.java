package listeners;

import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class CustomTestExecutionListener implements TestExecutionExceptionHandler {

    private static final Logger LOG = Logger.getLogger(CustomTestExecutionListener.class.getName());
    public static AppiumDriver appiumDriver;

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        takeScreenshot(appiumDriver, context.getDisplayName());
        LOG.severe("Test Failed: " + context.getDisplayName());
        LOG.severe("Error: " + throwable.getMessage());
        throw throwable;
    }

    private void takeScreenshot(AppiumDriver driver, String testName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = System.getProperty("user.dir") + "/target/screenshots/" + testName + ".png";
            File destDir = new File("screenshots");
            if (!destDir.exists())
                destDir.mkdirs();
            File destFile = new File(screenshotPath);
            Files.copy(screenshot, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
