package mobile.base;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import pageobjects.CreateAccountPage;
import pageobjects.WelcomePage;
import mobile.runners.TestRunner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestBase extends TestRunner {
    protected CreateAccountPage createAccountPage;
    protected WelcomePage welcomePage;
    protected SoftAssertions softAssertions;

    @BeforeAll
    void initPageObjects() {
        createAccountPage = new CreateAccountPage(driver);
        welcomePage = new WelcomePage(driver);
        softAssertions = new SoftAssertions();

    }
}
