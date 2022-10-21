package cucumber.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ex.ElementNotFound;
import config.ConfProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static cucumber.steps.Authorize.authorized;

public class Hooks {

    @Before("@recommendation")
    public void authorize() {
        try {
            authorized();
        }
        catch (ElementNotFound ex)
        {
            System.out.println("Авторизация не потребовалась"+ ex);
        }
    }

    @Before
    public void startBrowser() {
        Configuration.browserSize= "1024x768";
        String url = ConfProperties.getProperty("loginPageUrl");
        open(url);
    }

    @After("@success")
    public void getScenarioInfo(Scenario scenario) {
        System.out.println(scenario.getId());
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());
        System.out.println(scenario.isFailed());
        System.out.println(scenario.getSourceTagNames());
    }

    @After
    public void test(Scenario scenario) {
      sleep(50200000);
    }

}
