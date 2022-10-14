package cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/java/cucumber/features/RecommendationsPageTestCase.feature"}, glue = {"cucumber.steps"},
        plugin = {})
public class RecommendationRunnerTest extends AbstractTestNGCucumberTests {
}
