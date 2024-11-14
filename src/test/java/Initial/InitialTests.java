package Initial;

import Base.TestRunner;
import org.junit.jupiter.api.*;
import pageobjects.CreateAccountPage;
import pageobjects.WelcomePage;

import javax.inject.Inject;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InitialTests extends TestRunner {
    CreateAccountPage createAccountPage;
    WelcomePage welcomePage;

    @BeforeAll
    void init() {
        createAccountPage = new CreateAccountPage(driver);
        welcomePage = new WelcomePage(driver);
    }

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
}
