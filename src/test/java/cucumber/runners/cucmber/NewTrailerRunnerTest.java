package cucumber.runners.cucmber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/java/features/NewTrailersBlockTestCase.feature"}, glue = {"page.cucumberStepDefinition"},
        plugin = {})
public class NewTrailerRunnerTest extends AbstractTestNGCucumberTests {
}
