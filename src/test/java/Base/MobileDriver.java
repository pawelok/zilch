package Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.options.BaseOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriver {
    String platform = System.getenv("PLATFORM");
    String deviceUdid = System.getenv("DEVICE_UDID");
    String appId = System.getenv("APP_ID");
    private static final String appiumUrl = "http://127.0.0.1:4723";

    public AppiumDriver setUpDriver() {
        // Validate environment variables
        if (platform == null || deviceUdid == null) {
            throw new IllegalArgumentException("Both PLATFORM and DEVICE_UDID environment variables must be set.");
        }
        // Set capabilities based on platform (Android or iOS)
        switch (platform.toLowerCase()) {
            case "android":
                return getAndroidDriver();
            case "ios":
                return getIosDriver();
            default:
                throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }

    private AppiumDriver getIosDriver() {
        var options = new BaseOptions()
                .setPlatformName("iOS")
                .amend("platformVersion", "14.4") // Example version, adjust as needed
                .setAutomationName("XCUITest")
                .amend("appium:udid", deviceUdid)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:appPackage", appId);
        ;
        try {
            return new IOSDriver(getUrl(), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to initialize IOSDriver", e);
        }
    }


    private AppiumDriver getAndroidDriver() {
        var options = new BaseOptions()
                .setPlatformName("Android")
                .amend("appium:udid", "R8YWB0AWXYJ")
                .setAutomationName("UiAutomator2")
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true)
                .amend("appium:appPackage", appId)
                .amend("appium:disableIdLocatorAutocompletion", true)
                .amend("appium:appActivity", "com.payzilch.app.MainActivity");
        try {
            return new AndroidDriver(getUrl(), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to initialize AndroidDriver", e);
        }
    }

    private static URL getUrl() throws MalformedURLException {
        return new URL(appiumUrl);
    }
}
