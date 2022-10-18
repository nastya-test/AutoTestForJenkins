package cucumber.steps;

import com.codeborne.selenide.Selenide;
import cucumber.pageobjects.mainPage.FilmTicketsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import test.BaseTest;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import static cucumber.map.PageMap.savePageMap;
import static cucumber.map.PageMap.setPopularPages;
import static cucumber.steps.AbstractSteps.bestScroll;

public class Hooks {
    @After("@success")
    public void getScenarioInfo(Scenario scenario) {
        System.out.println(scenario.getId());
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());
        System.out.println(scenario.isFailed());
        System.out.println(scenario.getSourceTagNames());
    }

    @Before("@filmTickets")
    public void setFilmTickets() {
        BaseTest.baseOpenPage();
        setPopularPages(savePageMap.get("Блок Билеты в кино"));
        bestScroll(page(FilmTicketsPage.class).filmTicketsBlock);
        sleep(2000);
    }

}
