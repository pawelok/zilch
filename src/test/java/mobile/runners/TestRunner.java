package mobile.runners;

import com.google.inject.Guice;
import com.google.inject.Injector;
import configuration.PlatformModule;
import configuration.PropertiesReader;
import helpers.appium.PlatformInterface;
import io.appium.java_client.AppiumDriver;
import listeners.CustomTestExecutionListener;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import util.MobileDriver;

@Timeout(120)
@ExtendWith(CustomTestExecutionListener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestRunner {
    protected static String appId = PropertiesReader.getAppId();
    protected static String appActivity = PropertiesReader.getAppActivity();
    protected static String platform = PropertiesReader.getPlatform();
    protected AppiumDriver driver;
    protected PlatformInterface platformHelper;

    @BeforeAll
    public void initDriver() {
        driver = MobileDriver.setUpDriver(platform);
        CustomTestExecutionListener.appiumDriver = driver;
        Injector injector = Guice.createInjector(new PlatformModule(platform, driver));
        platformHelper = injector.getInstance(PlatformInterface.class);
    }

    @AfterAll
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
