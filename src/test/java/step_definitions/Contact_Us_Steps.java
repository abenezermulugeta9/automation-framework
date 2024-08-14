package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page_object.BasePageObject;
import page_object.ContactUsPageObject;

public class Contact_Us_Steps extends BasePageObject {

    private WebDriver driver = getDriver();

    private final ContactUsPageObject contactUsPageObject;

    public Contact_Us_Steps(ContactUsPageObject contactUsPageObject) {
        this.contactUsPageObject = contactUsPageObject;
    }

    @Given("I access the webdriver university contact us page")
    public void iAccessTheWebdriverUniversityContactUsPage() {
        contactUsPageObject.navigateToTestUrl();
    }

    @When("I enter a unique first name")
    public void iEnterAUniqueFirstName() {
        contactUsPageObject.setFirstNameField("AutoFirstName" + generateRandomNumber(5));
    }

    @And("I enter a unique last name")
    public void iEnterAUniqueLastName() {
        contactUsPageObject.setLastNameField("AutoLastName" + generateRandomNumber(5));
    }

    @And("I enter a unique email address")
    public void iEnterAUniqueEmailAddress() {
        contactUsPageObject.setEmailField("AutoEmail" + generateRandomNumber(10) + "@mail.com");
    }

    @And("I enter a unique comment")
    public void iEnterAUniqueComment() {
        contactUsPageObject.setCommentField("AutoMessage " + generateRandomString(20));
    }

    @And("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        contactUsPageObject.clickOnSubmitButton();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void iShouldBePresentedWithASuccessfulContactUsSubmissionMessage() {
        contactUsPageObject.validateSubmissionText("Thank You for your Message!");
    }

    @When("I enter a specific first name {word}")
    public void iEnterASpecificFirstName(String firstName) {
        contactUsPageObject.setFirstNameField(firstName);
    }

    @And("I enter a specific last name {word}")
    public void iEnterASpecificLastName(String lastName) {
        contactUsPageObject.setLastNameField(lastName);
    }

    @And("I enter a specific email address {word}")
    public void iEnterASpecificEmailAddress(String email) {
        contactUsPageObject.setEmailField(email);
    }

    @And("I enter a specific comment {string}")
    public void iEnterASpecificComment(String comment) {
        contactUsPageObject.setCommentField(comment);
    }
}
