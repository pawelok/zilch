package Base;

import Listeners.CustomTestExecutionListener;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import pageobjects.CreateAccountPage;
import pageobjects.WelcomePage;

@Timeout(120)
@ExtendWith(CustomTestExecutionListener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestRunner {
    protected AppiumDriver driver;
    private MobileDriver mobileDriver;

    public TestRunner() {
        this.mobileDriver = new MobileDriver();
    }

    @BeforeAll
    public void setUp() {
        driver = mobileDriver.setUpDriver();
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
