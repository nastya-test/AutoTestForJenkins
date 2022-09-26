package test.cucmber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/java/features/FilmTicketsBlockTestCase.feature"}, glue = {"page.cucumberStepDefinition"},
        plugin = {})
public class FilmTicketsRunnerTest extends AbstractTestNGCucumberTests {
}
