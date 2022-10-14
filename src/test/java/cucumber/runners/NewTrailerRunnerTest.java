package cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/java/cucumber/features/NewTrailersPageTestCase.feature"}, glue = {"cucumber.steps"},
        plugin = {})
public class NewTrailerRunnerTest extends AbstractTestNGCucumberTests {
}
