package step_definitions.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static driver.DriverFactory.getDriver;
import static driver.DriverFactory.quitAndCleanUpDriver;

public class Hooks {

    // executes before step definitions
    @Before
    public void setup() {
        getDriver();
    }

    // executes after step definitions
    @After
    public void tearDown() {
        quitAndCleanUpDriver();
    }
}
