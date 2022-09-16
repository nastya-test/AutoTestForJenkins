package test.cucmber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@success", features = {"src/test/java/features/LoginTestCase.feature"}, glue = {"page.cucumberStepDefinition"},
        plugin = {})
public class LoginRunnerTest extends AbstractTestNGCucumberTests {
}
