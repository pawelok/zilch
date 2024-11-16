package util;

import configuration.PropertiesReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriver {
    private static final String appiumUrl = "http://127.0.0.1:4723";
    static String appId = PropertiesReader.getAppId();
    static String appActivity = PropertiesReader.getAppActivity();
    static String deviceUdid = PropertiesReader.getDeviceUdid();

    public static AppiumDriver setUpDriver(String platform) {
        if (platform == null || deviceUdid == null) {
            throw new IllegalArgumentException("Both PLATFORM and DEVICE_UDID environment variables must be set.");
        }
        switch (platform.toLowerCase()) {
            case "android":
                return getAndroidDriver();
            case "ios":
                return getIosDriver();
            default:
                throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }

    private static AppiumDriver getIosDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "14.4"); // Default version if not set
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("udid", deviceUdid);
        capabilities.setCapability("newCommandTimeout", 3600);
        capabilities.setCapability("app", appId);

        try {
            return new IOSDriver(getUrl(), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to initialize IOSDriver", e);
        }
    }


    private static AppiumDriver getAndroidDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("udid", deviceUdid);
        capabilities.setCapability("newCommandTimeout", 3600);
        capabilities.setCapability("appPackage", appId);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("nativeWebScreenshot", true);
        capabilities.setCapability("connectHardwareKeyboard", true);
        capabilities.setCapability("disableIdLocatorAutocompletion", true);

        try {
            return new AndroidDriver(getUrl(), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to initialize AndroidDriver", e);
        }
    }

    private static URL getUrl() throws MalformedURLException {
        return new URL(appiumUrl);
    }
}
