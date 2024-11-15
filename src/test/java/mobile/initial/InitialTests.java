package mobile.initial;

import mobile.base.TestBase;
import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InitialTests extends TestBase {

    @Test
    @Order(1)
    public void verifyWelcomePageContent() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(welcomePage.isWelcomePageDisplayed(), "Welcome page was not displayed"),
                () -> Assertions.assertTrue(welcomePage.isCreateAccountButtonDisplayed(), "Create account button was not displayed"),
                () -> Assertions.assertTrue(welcomePage.isLoginButtonDisplayed(), "Login button was not displayed")
        );
    }

    @Test
    @Order(2)
    public void verifyCreateAccountContent() {
        welcomePage.clickOnCreateAccountButton();
        Assertions.assertAll(
                () -> Assertions.assertTrue(createAccountPage.isCreateAccountButtonDisplayed(), "Create account button was not displayed"),
                () -> Assertions.assertFalse(createAccountPage.isCreateAccountEnabled(), "Create account button was enabled"),
                () -> Assertions.assertTrue(createAccountPage.isEmailInputFieldDisplayed(), "Email input was not displayed"),
                () -> Assertions.assertTrue(createAccountPage.isPasswordInputFieldDisplayed(), "Password input was not displayed")
        );
    }

    @Test
    @Order(3)
    public void verifyIfKeyboardIsDisplayedAfterClickingEmailInputField() {
        createAccountPage.clickOnEmailIInputField();
        softAssertions.assertThat(platformHelper.isKeyboardDisplayed()).isEqualTo(true).withFailMessage("Keyboard was not displayed after clicking on email input field");
        platformHelper.hideKeyboard();
        softAssertions.assertAll();
    }

    @Test
    @Order(4)
    public void verifyIfKeyboardIsDisplayedAfterClickingPasswordInputField() {
        createAccountPage.clickOnPasswordInputField();
        softAssertions.assertThat(platformHelper.isKeyboardDisplayed()).isEqualTo(true).withFailMessage("Keyboard was not displayed after clicking on password input field");
        platformHelper.hideKeyboard();
        softAssertions.assertAll();
    }

    @Test
    @Order(5)
    public void verifyCreateAccountButtonIsDisabledWhenOnlyOneInputIsFilled() {
        createAccountPage.clickOnEmailIInputField();
        createAccountPage.fillEmailInput("test@test.test");
        platformHelper.hideKeyboard();
        softAssertions.assertThat(createAccountPage.isCreateAccountEnabled()).isEqualTo(false).withFailMessage("Create account button is enabled when only email field is filled");

        createAccountPage.clickOnEmailIInputField();
        createAccountPage.fillEmailInput("");
        platformHelper.hideKeyboard();
        createAccountPage.clickOnPasswordInputField();
        createAccountPage.fillPasswordInput("88888888");
        platformHelper.hideKeyboard();
        softAssertions.assertThat(createAccountPage.isCreateAccountEnabled()).isEqualTo(false).withFailMessage("Create account button is enabled when only password field is filled");

        softAssertions.assertAll();
    }
}
