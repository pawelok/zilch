package mobile.runners;

import com.google.inject.Guice;
import com.google.inject.Injector;
import configuration.PlatformAbstractModule;
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
    protected AppiumDriver driver;
    protected PlatformInterface platformHelper;
    static String platform = System.getenv("PLATFORM");
    static String deviceUdid = System.getenv("DEVICE_UDID");
    protected static String appId = System.getenv("APP_ID");
    protected static String appActivity = System.getenv("APP_ACTIVITY");

    @BeforeAll
    public void initDriver() {
        driver = MobileDriver.setUpDriver(platform, deviceUdid);
        CustomTestExecutionListener.appiumDriver = driver;
        Injector injector = Guice.createInjector(new PlatformAbstractModule(platform, driver));
        platformHelper = injector.getInstance(PlatformInterface.class);
    }

    @AfterAll
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
