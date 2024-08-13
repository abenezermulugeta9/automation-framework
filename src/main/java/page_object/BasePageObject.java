package page_object;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

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
}
