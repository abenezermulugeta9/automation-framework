package page_object;

public class LoginPageObject extends BasePageObject {

    public LoginPageObject() {
        super();
    }

    public void navigateToTestUrl() {
        setTestUrl("https://webdriveruniversity.com/Login-Portal/index.html");
    }
}
