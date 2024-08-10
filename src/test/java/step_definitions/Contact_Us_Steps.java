package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Contact_Us_Steps {

    private WebDriver driver;

    @Before
    public void setup() {
        // absolute path of the driver's location
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        // when set to normal, this make Selenium WebDriver to wait for the entire page is loaded
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        // without this line exception will be thrown: org.openqa.selenium.remote.http.ConnectionFailedException: Unable to establish websocket
        chromeOptions.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I access the webdriver university contact us page")
    public void iAccessTheWebdriverUniversityContactUsPage() {
        System.out.println("Test1");
    }

    @When("I enter a unique first name")
    public void iEnterAUniqueFirstName() {
        System.out.println("Test2");

    }

    @And("I enter a unique last name")
    public void iEnterAUniqueLastName() {
        System.out.println("Test3");

    }

    @And("I enter a unique email address")
    public void iEnterAUniqueEmailAddress() {
        System.out.println("Test4");

    }

    @And("I enter a unique comment")
    public void iEnterAUniqueComment() {
        System.out.println("Test5");

    }

    @And("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        System.out.println("Test6");

    }

    @Then("I should be presented with a successful contact us submission message")
    public void iShouldBePresentedWithASuccessfulContactUsSubmissionMessage() {
        System.out.println("Test7");
    }
}
