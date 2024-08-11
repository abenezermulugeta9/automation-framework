package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Login_Steps {

    private WebDriver driver;

    @Before("@login")
    public  void setup() {
        // absolute path of the driver's location
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        // when set to normal, this make Selenium WebDriver to wait for the entire page is loaded
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        // without this line exception will be thrown:
        // org.openqa.selenium.remote.http.ConnectionFailedException: Unable to establish websocket
        chromeOptions.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After("@login")
    public void tearDown() {
        driver.quit();
    }

    @Given("I access the the WebDriver University login page")
    public void iAccessTheTheWebDriverUniversityLoginPage() {
        driver.get("https://webdriveruniversity.com/Login-Portal/index.html");
    }

    @When("I enter a username {string}")
    public void iEnterAUsername(String username) {
        driver.findElement(By.id("text")).sendKeys(username);
    }

    @And("I enter a password {}")
    public void iEnterAPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("I click on the login button")
    public void iClickOnLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be presented with a successful login message")
    public void iShouldBePresentedWithASuccessfulLoginMessage() {
        String loginMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(loginMessage, "validation succeeded");
    }

    @Then("I should be presented with a failed login message")
    public void iShouldBePresentedWithAFailedLoginMessage() {
        String loginMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(loginMessage, "validation failed");
    }
}
