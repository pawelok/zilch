package configuration;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import helpers.appium.AndroidHelper;
import helpers.appium.IosHelper;
import helpers.appium.PlatformInterface;
import io.appium.java_client.AppiumDriver;

import static util.TestConstants.ANDROID;
import static util.TestConstants.IOS;

public class PlatformAbstractModule extends AbstractModule {

    private final String platform;
    private final AppiumDriver driver;

    public PlatformAbstractModule(String platform, AppiumDriver driver) {
        this.platform = platform;
        this.driver = driver;
    }

    @Override
    protected void configure() {
        if (IOS.equalsIgnoreCase(platform)) {
            bind(PlatformInterface.class).to(IosHelper.class);
        } else if (ANDROID.equalsIgnoreCase(platform)) {
            bind(PlatformInterface.class).to(AndroidHelper.class);
        } else {
            throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }

    @Provides
    @Singleton
    public AppiumDriver provideDriver() {
        return driver;
    }
}