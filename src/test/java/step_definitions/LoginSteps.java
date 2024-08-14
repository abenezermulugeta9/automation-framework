package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object.BasePageObject;
import page_object.LoginPageObject;

public class LoginSteps extends BasePageObject {

    private final LoginPageObject loginPageObject;

    public LoginSteps(LoginPageObject loginPageObject) {
        this.loginPageObject = loginPageObject;
    }

    @Given("I access the the WebDriver University login page")
    public void iAccessTheTheWebDriverUniversityLoginPage() {
        loginPageObject.navigateToTestUrl();
    }

    @When("I enter a username {string}")
    public void iEnterAUsername(String username) {
        loginPageObject.setUsernameField(username);
    }

    @And("I enter a password {}")
    public void iEnterAPassword(String password) {
        loginPageObject.setPasswordField(password);
    }

    @And("I click on the login button")
    public void iClickOnLoginButton() {
        loginPageObject.clickOnLoginButton();
    }

    @Then("I should be presented with a {} login message")
    public void iShouldBePresentedWithALoginMessage(String validationMessage) {
        loginPageObject.validateLoginMessage(validationMessage);
    }
}
