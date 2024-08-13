package page_object;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObject {

    public BasePageObject() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    protected String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    protected String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    protected void setTestUrl(String url) {
        getDriver().get(url);
    }


    protected void sendKeys(By by, String payload) {
        /**
         * WebDriverWait in Selenium is used to introduce a wait in the script until a certain condition is met. This
         * is particularly useful when dealing with dynamic web pages where elements may take some time to load or
         * become visible.
         */
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(payload);
    }

    protected void sendKeys(WebElement webElement, String payload) {
        /**
         * WebDriverWait in Selenium is used to introduce a wait in the script until a certain condition is met. This
         * is particularly useful when dealing with dynamic web pages where elements may take some time to load or
         * become visible.
         */
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(payload);
    }

    protected void waitForWebElementAndClick(By by) {
        /**
         * WebDriverWait in Selenium is used to introduce a wait in the script until a certain condition is met. This
         * is particularly useful when dealing with dynamic web pages where elements may take some time to load or
         * become visible.
         */
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected void waitForWebElementAndClick(WebElement webElement) {
        /**
         * WebDriverWait in Selenium is used to introduce a wait in the script until a certain condition is met. This
         * is particularly useful when dealing with dynamic web pages where elements may take some time to load or
         * become visible.
         */
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
}
