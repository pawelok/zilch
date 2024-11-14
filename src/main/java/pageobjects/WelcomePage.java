package pageobjects;

import helpers.AppiumHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends BasePage{

//    AppiumDriver driver;
    //TODO add ios locators
    @AndroidFindBy(id = "welcome-screen")
    @iOSXCUITFindBy(id = "xxx")
    public WebElement welcomePage ;

    @AndroidFindBy(id = "welcome-get-started")
    @iOSXCUITFindBy(id = "xxx")
    public WebElement createAccountButton ;

    @AndroidFindBy(id = "welcome-log-in")
    @iOSXCUITFindBy(accessibility = "xxx")
    public WebElement loginButton;


    public WelcomePage(AppiumDriver driver){
        super(driver);
//        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isWelcomePageDisplayed(){
        return appiumHelper.isElementDisplayed(welcomePage);
    }

    public boolean isCreateAccountButtonDisplayed(){
        return appiumHelper.isElementDisplayed(createAccountButton);
    }

    public boolean isLoginButtonDisplayed(){
        return appiumHelper.isElementDisplayed(createAccountButton);
    }

    public void clickOnCreateAccountButton(){
        createAccountButton.click();
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }
}
