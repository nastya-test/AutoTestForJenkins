package cucumber.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import test.BaseTest;
import static cucumber.map.PageMap.*;
import static test.BaseTest.authorized;

public class BaseSteps {
    @Дано("открывает главную страницу")
    public void открывает_главную_страницу() {
        BaseTest.baseOpenPage();
    }

    @И("устанавливает страницу {string}, как активную")
    public void устанавливаетСтраницуКакАктивную(String page) {
        setPopularPages(savePageMap.get(page));
    }

    @И("авторизуется")
    public void авторизуется() {
        authorized();
    }
}
