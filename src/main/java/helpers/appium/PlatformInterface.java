package helpers.appium;

public interface PlatformInterface {

    boolean isKeyboardDisplayed();

    void hideKeyboard();

    void pressOnReturnKey();

    void restartApp(String appId, String appActivity);
}
