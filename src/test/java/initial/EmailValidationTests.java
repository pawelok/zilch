package initial;

import base.TestBase;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmailValidationTests extends TestBase {

    String testingPassword = "88888888";

    @BeforeEach
    void preconditions() {
        welcomePage.isWelcomePageDisplayed();
        welcomePage.clickOnCreateAccountButton();
    }

    @ParameterizedTest(name = "{index} => email={0}")
    @CsvFileSource(resources = "/email_correct_test_data.csv")
    public void validateEmailInputField(String email) {
        createAccountPage.clickOnEmailIInputField();
        createAccountPage.fillEmailInput(email);
        createAccountPage.clickOnPasswordInputField();
        createAccountPage.fillPasswordInput(testingPassword);
        platformHelper.hideKeyboard();
        createAccountPage.clickOnCreateAccountButton();
        Assertions.assertTrue(createAccountPage.isMobileInputOrCaptchaDisplayed(), "Email was not accepted when creating new account: " + email);
    }

    //App is starting to crash after multiple attempts, so that the most reliable solution for now
    @AfterEach
    public void restartApp() {
        platformHelper.restartApp(appId, appActivity);
    }

    //    @AfterEach
    public void returnToWelcomePage() {
        if (platformHelper.isKeyboardDisplayed())
            platformHelper.hideKeyboard();
        if (createAccountPage.isMobileInputOrCaptchaDisplayed())
            platformHelper.pressOnReturnKey();
        if (createAccountPage.isEmailInputFieldDisplayed())
            platformHelper.pressOnReturnKey();
    }
}
