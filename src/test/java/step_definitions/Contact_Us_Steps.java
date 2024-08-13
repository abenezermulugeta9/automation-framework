package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page_object.BasePageObject;

public class Contact_Us_Steps extends BasePageObject {

    private WebDriver driver = getDriver();

    @Given("I access the webdriver university contact us page")
    public void iAccessTheWebdriverUniversityContactUsPage() {
        setTestUrl("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void iEnterAUniqueFirstName() {
        sendKeys(By.xpath("//input[@name='first_name']"), "AutoFirstName" + generateRandomNumber(5));
    }

    @And("I enter a unique last name")
    public void iEnterAUniqueLastName() {
        sendKeys(By.xpath("//input[@name='last_name']"), "AutoLastName" + generateRandomNumber(5));
    }

    @And("I enter a unique email address")
    public void iEnterAUniqueEmailAddress() {
        sendKeys(By.xpath("//input[@name='email']"), "AutoEmail" + generateRandomNumber(10) + "@mail.com");
    }

    @And("I enter a unique comment")
    public void iEnterAUniqueComment() {
        sendKeys(By.xpath("//textarea[@name='message']"), "AutoMessage " + generateRandomString(20));
    }

    @And("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        waitForWebElementAndClick(By.xpath("//input[@value='SUBMIT']"));
    }

    @Then("I should be presented with a successful contact us submission message")
    public void iShouldBePresentedWithASuccessfulContactUsSubmissionMessage() {
        WebElement contactUsResponseCard = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUsResponseCard.getText(), "Thank You for your Message!");
    }

    @When("I enter a specific first name {word}")
    public void iEnterASpecificFirstName(String firstName) {
        sendKeys(By.xpath("//input[@name='first_name']"), firstName);
    }

    @And("I enter a specific last name {word}")
    public void iEnterASpecificLastName(String lastName) {
        sendKeys(By.xpath("//input[@name='last_name']"), lastName);
    }

    @And("I enter a specific email address {word}")
    public void iEnterASpecificEmailAddress(String email) {
        sendKeys(By.xpath("//input[@name='email']"), email);
    }

    @And("I enter a specific comment {string}")
    public void iEnterASpecificComment(String comment) {
        sendKeys(By.xpath("//textarea[@name='message']"), comment);
    }
}
