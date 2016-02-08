package my.company.tests;

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

@Title("Suite contain negative cases")
@Description("In this suite we'll test login form in negative case")
public class LoginNegativeTest extends TestSettings {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Email validation")
    @Test
    public void typeInvalidEmail() throws Exception {
        LandingPage lp = new LandingPage(driver);
        lp.openLoginForm();
        lp.submitLogin("tazg@yaru", valid_password);
        assertEquals("This value should be a valid email.", lp.invalidEmailError());
        lp.submitLogin("tazg@ya.", valid_password);
        assertEquals("This value should be a valid email.", lp.invalidEmailError());
        lp.submitLogin("tazg@ya", valid_password);
        assertEquals("This value should be a valid email.", lp.invalidEmailError());
        lp.submitLogin("tazg@", valid_password);
        assertEquals("This value should be a valid email.", lp.invalidEmailError());
        lp.submitLogin("tazg", valid_password);
        assertEquals("This value should be a valid email.", lp.invalidEmailError());
        lp.submitLogin("@.", valid_password);
        assertEquals("This value should be a valid email.", lp.invalidEmailError());
        lp.submitLogin("", valid_password);
        assertEquals("This value is required.", lp.getThisValueRequiredMsg());

    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("Password validation")
    @Test
    public void typeInvalidPassword() throws Exception {
        LandingPage lp = new LandingPage(driver);
        lp.openLoginForm();
        lp.submitLogin(valid_email, "");
        assertEquals("Invalid login or password", lp.getInvalidLoginOrPasswordMsg());
        lp.submitLogin(valid_email, "ABCDEF123456");
        assertEquals("Invalid login or password", lp.getInvalidLoginOrPasswordMsg());
        lp.submitLogin(valid_email, "abcdef123456");
        assertEquals("Invalid login or password", lp.getInvalidLoginOrPasswordMsg());
        lp.submitLogin(valid_email, "abcDEF12345'");
        assertEquals("Invalid login or password", lp.getInvalidLoginOrPasswordMsg());
        lp.submitLogin(valid_email, " abcDEF12345");
        assertEquals("Invalid login or password", lp.getInvalidLoginOrPasswordMsg());
        lp.submitLogin(valid_email, "<script>alert(123)</script>");
        assertEquals("Invalid login or password", lp.getInvalidLoginOrPasswordMsg());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Empty email and password")
    @Test
    public void typeEmptyEmailAndPassword() throws Exception {
        LandingPage lp = new LandingPage(driver);
        lp.openLoginForm();
        lp.submitLogin("", "");
        assertEquals("This value is required.", lp.getThisValueRequiredMsg());
    }


}

