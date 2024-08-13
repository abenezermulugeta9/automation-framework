package page_object;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObject {

    public BasePageObject() {
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
}
