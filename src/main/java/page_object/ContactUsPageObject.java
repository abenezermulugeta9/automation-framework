package page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPageObject extends BasePageObject {

    private @FindBy(xpath = "//input[@name='first_name']") WebElement firstNameField;
    private @FindBy(xpath = "//input[@name='last_name']") WebElement lastNameField;
    private @FindBy(xpath = "//input[@name='email']") WebElement emailField;
    private @FindBy(xpath = "//textarea[@name='message']") WebElement commentField;
    private @FindBy(xpath = "//input[@value='SUBMIT']") WebElement submitButton;

    public ContactUsPageObject() {
        super();
    }

    public void navigateToTestUrl() {
        setTestUrl("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    public void setFirstNameField(String firstName) {
        sendKeys(firstNameField, firstName);
    }

    public void setLastNameField(String lastName) {
        sendKeys(lastNameField, lastName);
    }

    public void setEmailField(String email) {
        sendKeys(emailField, email);
    }

    public void setCommentField(String comment) {
        sendKeys(commentField, comment);
    }
}
