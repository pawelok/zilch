package pageobjects;

import appium.AppiumHelper;
import io.appium.java_client.AppiumDriver;

public class Base {
    public AppiumHelper appiumHelper;
    AppiumDriver driver;

    Base(AppiumDriver driver) {
        this.driver = driver;
        appiumHelper = new AppiumHelper();
    }
}
