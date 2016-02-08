package my.company.steps;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;


/**
 * @author Nikita Ivanov tazg@ya.ru
 *         Date: 6.02.16
 */

public class TestSettings {

    protected WebDriver driver;
    protected String valid_email = "tazg@ya.ru";
    protected String valid_password = "abcDEF12345";
    protected Calendar rightNow;

    @Before //will be executed before every test
    public void setUp() {
        driver = new FirefoxDriver(); //определяем что будем использовать Firefox
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //определяем неявные ожидания
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.get("https://news360.com/"); //открываем страницу

    }

    @After //will be executed after every test
    public void tearDown() {
        driver.quit(); //close browser and clear sesion
    }
}

