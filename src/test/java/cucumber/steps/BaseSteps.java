package cucumber.steps;

import io.cucumber.java.ru.Дано;
import test.BaseTest;

public class BaseSteps {
    @Дано("открывает главную страницу")
    public void открывает_главную_страницу() {
        BaseTest.baseOpenPage();
    }
}
