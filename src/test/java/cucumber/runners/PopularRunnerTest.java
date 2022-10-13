package cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/java/features/PopularBlockTestCase.feature"}, glue = {"page.cucumberStepDefinition"},
        plugin = {})
public class PopularRunnerTest extends AbstractTestNGCucumberTests {
}
