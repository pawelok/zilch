package pageobjects;

import helpers.AppiumHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends BasePage {

    //TODO add ios locators
    @AndroidFindBy(id = "email-field")
    @iOSXCUITFindBy(id = "xxx")
    public WebElement emailInputField;

    @AndroidFindBy(id = "email-field-error-validation")
    @iOSXCUITFindBy(id = "xxx")
    public WebElement emailValidationErrorText;

    @AndroidFindBy(id = "password-field")
    @iOSXCUITFindBy(id = "xxx")
    public WebElement passwordInputField;

    @AndroidFindBy(id = "password-field-error-validation")
    @iOSXCUITFindBy(id = "xxx")
    public WebElement passwordValidationErrorText;

    @AndroidFindBy(id = "create-account-button")
    @iOSXCUITFindBy(id = "xxx")
    public WebElement createAccountButton;


    public CreateAccountPage(AppiumDriver driver) {
        super(driver);
//        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isEmailInputFieldDisplayed() {
        return appiumHelper.isElementDisplayed(emailInputField);
    }

    public boolean isPasswordInputFieldDisplayed() {
        return appiumHelper.isElementDisplayed(passwordInputField);
    }

    public boolean isCreateAccountButtonDisplayed() {
        return appiumHelper.isElementDisplayed(createAccountButton);
    }

    public void fillEmailInput(String email) {
        emailInputField.clear();
        emailInputField.sendKeys(email);
    }

    public void fillPasswordInput(String password) {
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }

    public void clickOnCreateAccountButton() {
        createAccountButton.click();
    }

    public boolean isCreateAccountEnabled() {
        return createAccountButton.isEnabled();
    }

    public String getEmailValidationErrorText() {
        return emailValidationErrorText.getText();
    }

    public String getPasswordValidationErrorText() {
        return passwordValidationErrorText.getText();
    }
}
