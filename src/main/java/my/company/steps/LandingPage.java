package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author Nikita Ivanov tazg@ya.ru
 *         Date: 6.02.16
 */

public class LandingPage {

    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    By invalidEmailErrorLocator = By.cssSelector(".parsley-error-list li.type");
    By signUpLocator = By.cssSelector("a.signup:nth-child(2)");
    By errorMsgOnTopLocator = By.cssSelector("div[ng-bind=\"::localization.landing_invalid_login\"][style=\"display: block;\"]");
    By errorMsgLocator = By.cssSelector(".parsley-error-list li.required");
    By startReadingLocator = By.cssSelector("a.eNav.startreading.ng-binding");
    By signInWithEmailLocator = By.cssSelector("a.expand.fancybox.login-signin.ng-binding");
    By EmailLoginFieldLocator = By.xpath("(//input[@type='email'])[3]"); //поле для ввода e-mail
    By PasswdLoginFieldLocator = By.xpath("(//input[@type='password'])[10]"); //поле для ввода пароля
    By signInButtonLocator = By.xpath("(//button[@type='submit'])[4]"); //кнопка Войти
    By confirmPasswordFieldLocator = By.cssSelector("css=input.confirmpassword.textbox[data-equalto=\"#popuppassword\"]"); //кнопка Войти

    @Step
    public void userTypeEmailInLoginForm(String email) {
        driver.findElement(EmailLoginFieldLocator).click();
        driver.findElement(EmailLoginFieldLocator).clear();
        driver.findElement(EmailLoginFieldLocator).sendKeys(email);
    }

    @Step
    public void userTypePasswdInLoginForm(String password) {
        driver.findElement(PasswdLoginFieldLocator).click();
        driver.findElement(PasswdLoginFieldLocator).clear();
        driver.findElement(PasswdLoginFieldLocator).sendKeys(password);
    }

    @Step
    public void userTypeConfirmPasswdInSignUpForm(String password) {
        driver.findElement(confirmPasswordFieldLocator).click();
        driver.findElement(confirmPasswordFieldLocator).clear();
        driver.findElement(confirmPasswordFieldLocator).sendKeys(password);
    }

    @Step
    public void userClickStartReading() {
        driver.findElement(startReadingLocator).click();
    }

    @Step
    public void clickSignUp() {
        driver.findElement(signUpLocator).click();
    }

    @Step
    public void userClickSignInWithEmail() {
        driver.findElement(signInWithEmailLocator).click();
    }

    @Step
    public void userClickSignInButton() { //метод для клика по кнопке войти
        driver.findElement(signInButtonLocator).click(); //находим элемент и кликаем по нему
    }

    @Step
    public void openLoginForm() { //объединяем все 3 метода в один, который возвращает нам уже новую страницу
        userClickStartReading();
        userClickSignInWithEmail();
    }

    @Step
    public HomePage submitLogin(String email, String password) { //объединяем все 3 метода в один, который возвращает нам уже новую страницу
        userTypeEmailInLoginForm(email); //вводим email
        userTypePasswdInLoginForm(password); //вводим проль
        userClickSignInButton(); //кликаем войти
        return new HomePage(driver); //получаем страницу почты
    }

    @Step
    public HomePage submitSignUp(String email, String password, String confirmPassword) { //объединяем все 3 метода в один, который возвращает нам уже новую страницу
        userTypeEmailInLoginForm(email); //вводим email
        userTypePasswdInLoginForm(password); //вводим проль
        userTypeConfirmPasswdInSignUpForm(confirmPassword);
        userClickSignInButton(); //кликаем войти
        return new HomePage(driver); //получаем страницу почты
    }

    @Step
    public LandingPage submitLoginExpectingFailure(String email, String password) {
        userClickStartReading();
        userClickSignInWithEmail();
        userTypeEmailInLoginForm(email); //вводим email
        userTypePasswdInLoginForm(password); //вводим проль
        userClickSignInButton();
        return new LandingPage(driver);
    }

    @Step
    public String getThisValueRequiredMsg() { //метод для клика по кнопке войти
        return driver.findElement(errorMsgLocator).getText(); //находим элемент и кликаем по нему
    }

    @Step
    public String invalidEmailError() { //метод для клика по кнопке войти
        return driver.findElement(invalidEmailErrorLocator).getText(); //находим элемент и кликаем по нему
    }

    public String getInvalidLoginOrPasswordMsg() { //метод для клика по кнопке войти
        return driver.findElement(errorMsgOnTopLocator).getText(); //находим элемент и кликаем по нему
    }

}
