package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @features: specified location of feature files
 * @glue: specifies location of step definitions
 * @monochrome:control formatting of the console output
 * @dryRun: if set to true cucumber checks if a step in scenario has
 * a corresponding step definition, but not actually run the step definitions
 */
@CucumberOptions(features = {"classpath:features"}, glue = {"step_definitions"}, monochrome = true, dryRun = false)
public class MainRunner extends AbstractTestNGCucumberTests {
}
