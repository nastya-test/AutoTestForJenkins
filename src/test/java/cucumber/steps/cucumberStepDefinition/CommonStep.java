package cucumber.steps.cucumberStepDefinition;

import io.cucumber.java.ru.Дано;
import test.BaseTest;

public class CommonStep {
    @Дано("открывает главную страницу")
    public void открывает_главную_страницу() {
        BaseTest.baseOpenPage();
//        int d= 1;
    }

}
