package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * @param features   specified location of feature files
 * @param glue       specifies location of step definitions
 * @param tags       specifies which scenario/ feature should be included in cucumber test runner
 * @param monochrome control formatting of the console output
 * @param dryRun     if set to true cucumber checks if a step in scenario has
 *                   a corresponding step definition, but not actually run the step definitions
 * @param plugin     adds more information about our scenario steps in the console output and export report to html & json
 */
@CucumberOptions(features = {"classpath:features"},
        glue = {"step_definitions"},
        // tags = "@contact-us",
        // tags = "@login",
        // tags = "@contact-us-unique-data",
        // tags = "@contact-us-specific-data",
        tags = "@regression",
        monochrome = true,
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-report", "json:target/cucumber-report.json"})
public class MainRunner extends AbstractTestNGCucumberTests {

    // runs tests in parallel
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
