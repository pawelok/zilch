package pageobjects;

import com.fasterxml.jackson.databind.ser.Serializers;
import helpers.AppiumHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    AppiumDriver driver;
    AppiumHelper appiumHelper;

    BasePage(AppiumDriver driver){
        driver = this.driver;
        appiumHelper = new AppiumHelper();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
