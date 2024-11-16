package appium;

import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class IosHelper implements PlatformInterface {

    IOSDriver driver;

    @Inject
    public IosHelper(AppiumDriver appiumDriver) {
        this.driver = (IOSDriver) appiumDriver;
    }

    @Override
    public boolean isKeyboardDisplayed() {
        return driver.isKeyboardShown();
    }

    @Override
    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    @Override
    public void pressOnReturnKey() {

    }

    @Override
    public void restartApp(String appId, String appActivity) {
        driver.terminateApp(appId);
        driver.activateApp(appId);
    }
}
