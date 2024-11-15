package helpers.appium;

import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AndroidHelper implements PlatformInterface {

    AndroidDriver driver;

    @Inject
    public AndroidHelper(AppiumDriver appiumDriver) {
        this.driver = (AndroidDriver) appiumDriver;
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
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    @Override
    public void restartApp(String appId, String appActivity) {
        driver.terminateApp(appId);
        driver.startActivity(new Activity(appId, appActivity));
    }
}
