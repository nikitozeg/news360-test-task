package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author Nikita Ivanov tazg@ya.ru
 *         Date: 6.02.16
 */
public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By appNameLocator = By.cssSelector(".ebutton.ng-binding");

    @Step
    public String backToHomeIsDisplayed() throws InterruptedException {
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ebutton.ng-binding")));
        return driver.findElement(appNameLocator).getText();
    }

}
