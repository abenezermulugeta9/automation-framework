package page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.GlobalVars;

public class LoginPageObject extends BasePageObject {

    private @FindBy(id = "text") WebElement usernameField;
    private @FindBy(id = "password") WebElement passwordField;
    private @FindBy(id = "login-button") WebElement loginButton;

    public LoginPageObject() {
        super();
    }

    public void navigateToTestUrl() {
        setTestUrl(GlobalVars.WEBDRIVER_UNIVERSITY_LOGIN_PAGE_URL);
    }

    public void setUsernameField(String username) {
        sendKeys(usernameField, username);
    }

    public void setPasswordField(String password) {
        sendKeys(passwordField, password);
    }

    public void clickOnLoginButton() {
        waitForWebElementAndClick(loginButton);
    }

    public void validateLoginMessage(String message) {
        waitForAlertAndValidateText(message);
    }
}
