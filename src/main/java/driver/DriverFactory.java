package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    // using threads allows running tests in parallel
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }

        return webDriver.get();
    }

    public static WebDriver createDriver() {
        WebDriver driver = null;
        String browser = "chrome";

        switch (browser) {
            case "chrome" -> {
                // absolute path of the driver's location
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver.exe");

                ChromeOptions chromeOptions = new ChromeOptions();
                // when set to normal, this make Selenium WebDriver to wait for the entire page is loaded
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                // without this line exception will be thrown:
                // org.openqa.selenium.remote.http.ConnectionFailedException: Unable to establish websocket
                chromeOptions.addArguments("--remote-allow-origins=*");

                driver = new ChromeDriver(chromeOptions);

                break;
            }
            case "firefox" -> {
                // absolute path of the driver's location
                System.setProperty("webdriver.gecko.driver",
                        System.getProperty("user.dir") + "/src/main/java/driver/drivers/geckodriver.exe");

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                // when set to normal, this make Selenium WebDriver to wait for the entire page is loaded
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                // without this line exception will be thrown:
                // org.openqa.selenium.remote.http.ConnectionFailedException: Unable to establish websocket
                firefoxOptions.addArguments("--remote-allow-origins=*");

                driver = new FirefoxDriver(firefoxOptions);

                break;
            }
        }

        driver.manage().window().maximize();

        return driver;
    }

    public static void quitAndCleanUpDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}
