package page.cucumberStepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {
    @After
    public void getScenarioInfo(Scenario scenario) {
        System.out.println(scenario.getId());
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());
        System.out.println(scenario.isFailed());
        System.out.println(scenario.getSourceTagNames());
    }
}
