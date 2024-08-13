package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page_object.BasePageObject;

public class Login_Steps extends BasePageObject {

    private WebDriver driver = getDriver();

    @Given("I access the the WebDriver University login page")
    public void iAccessTheTheWebDriverUniversityLoginPage() {
        setTestUrl("https://webdriveruniversity.com/Login-Portal/index.html");
    }

    @When("I enter a username {string}")
    public void iEnterAUsername(String username) {
        sendKeys(By.id("text"), username);
    }

    @And("I enter a password {}")
    public void iEnterAPassword(String password) {
        sendKeys(By.id("password"), password);
    }

    @And("I click on the login button")
    public void iClickOnLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be presented with a {} login message")
    public void iShouldBePresentedWithALoginMessage(String validationMessage) {
        String loginMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(loginMessage, validationMessage);
    }
}
