package test.cucmber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/java/features/PopoverTestCase.feature"}, glue = {"page.cucumberStepDefinition"},
        plugin = {})
public class PopoverRunnerTest extends AbstractTestNGCucumberTests {
}
