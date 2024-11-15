package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends Base {

    //TODO add ios locators
    @AndroidFindBy(id = "email-field")
    @iOSXCUITFindBy(id = "")
    public WebElement emailInputField;

    @AndroidFindBy(id = "email-field-error-validation")
    @iOSXCUITFindBy(id = "")
    public WebElement emailValidationErrorText;

    @AndroidFindBy(id = "password-field")
    @iOSXCUITFindBy(id = "")
    public WebElement passwordInputField;

    @AndroidFindBy(id = "password-field-error-validation")
    @iOSXCUITFindBy(id = "")
    public WebElement passwordValidationErrorText;

    @AndroidFindBy(id = "create-account-button")
    @iOSXCUITFindBy(id = "")
    public WebElement createAccountButton;

    @AndroidFindBy(id = "mobile-number-input")
    @iOSXCUITFindBy(id = "")
    public WebElement mobileInputField;

    @AndroidFindBy(id = "nav-header-back-btn")
    @iOSXCUITFindBy(id = "")
    public WebElement backButton;

    @AndroidFindBy(id = "FunCaptcha")
    @iOSXCUITFindBy(id = "")
    public WebElement funCaptchaWindow;

    @AndroidFindAll({@AndroidBy(id = "FunCaptcha"), @AndroidBy(id = "mobile-number-input")})
    @iOSXCUITFindBy(id = "")
    public WebElement mobileInputFieldOrCaptcha;

    public CreateAccountPage(AppiumDriver driver) {
        super(driver);
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

    public boolean isMobileInputFieldIsDisplayed() {
        return appiumHelper.isElementDisplayed(mobileInputField);
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

    public void clickOnEmailIInputField() {
        emailInputField.click();
    }

    public void clickOnPasswordInputField() {
        passwordInputField.click();
    }

    public void clickOnBackButton() {
        backButton.click();
    }

    public boolean ifFunCaptchaWindowDisplayed() {
        return appiumHelper.isElementDisplayed(funCaptchaWindow);
    }

    public boolean isMobileInputOrCaptchaDisplayed() {
        return appiumHelper.isElementDisplayed(mobileInputFieldOrCaptcha);
    }
}
