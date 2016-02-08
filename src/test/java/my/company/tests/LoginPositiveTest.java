package my.company.tests;

import my.company.steps.HomePage;
import my.company.steps.LandingPage;
import my.company.steps.TestSettings;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import static org.junit.Assert.assertEquals;

/**
 * @author Nikita Ivanov tazg@ya.ru
 *         Date: 6.02.16
 */

@Title("Suite contain positive cases")
@Description("In this suite we'll test login form in positive case")
public class LoginPositiveTest extends TestSettings {

    @Severity(SeverityLevel.BLOCKER)
    @Description("Valid email and password")
    @Test
    public void correctEmail() throws Exception {
        LandingPage lp = new LandingPage(driver);
        lp.openLoginForm();
        HomePage homepage = lp.submitLogin(valid_email, valid_password);
        assertEquals("Back to Home", homepage.backToHomeIsDisplayed());
    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("Email in uppercase")
    @Test
    public void upperCaseEmail() throws Exception {
        LandingPage lp = new LandingPage(driver);
        lp.openLoginForm();
        HomePage homepage = lp.submitLogin(valid_email.toUpperCase(), valid_password);
        assertEquals("Back to Home", homepage.backToHomeIsDisplayed());
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Email with space on the end")
    @Test
    public void emailWithSpaces() throws Exception {
        LandingPage lp = new LandingPage(driver);
        lp.openLoginForm();
        HomePage homepage = lp.submitLogin(" " + valid_email.toUpperCase() + " ", valid_password);
        assertEquals("Back to Home", homepage.backToHomeIsDisplayed());
    }


}

