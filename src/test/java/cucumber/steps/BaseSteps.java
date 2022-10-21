package cucumber.steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import java.time.Duration;
import static cucumber.map.PageMap.*;
import static cucumber.pageobjects.mainPage.MainPage.elementMainPage;

public class BaseSteps {

    @Дано("открывает главную страницу")
    public void открывает_главную_страницу() {
        elementMainPage.shouldBe(Condition.visible, Duration.ofMinutes(1));
    }

    @И("устанавливает страницу {string}, как активную")
    public void устанавливаетСтраницуКакАктивную(String page) {
        setPopularPages(savePageMap.get(page));
    }

}
