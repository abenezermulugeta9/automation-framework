package step_definitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.Timestamp;

import static driver.DriverFactory.getDriver;
import static driver.DriverFactory.quitAndCleanUpDriver;

public class Hooks {

    // executes before step definitions
    @Before
    public void setup() {
        getDriver();
    }

    // executes after each step
    @AfterStep
    public void captureExceptionScreenshot(Scenario scenario) {
        // take a screenshot if an exception is thrown when executing tests
        if (scenario.isFailed()) {
            // get current time in milliseconds for naming screenshots
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeInMilliseconds = Long.toString(timestamp.getTime());

            // take a screenshot and attach it to the failed scenario
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", timeInMilliseconds);
        }
    }

    @After
    public void tearDown() {
        quitAndCleanUpDriver();
    }
}
