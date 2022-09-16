package page.cucumberStepDefinition;

import config.ConfProperties;
import io.cucumber.java.ru.Дано;
import test.BaseTest;


public class CommonStep {
    @Дано("открывает главную страницу")
    public void открывает_главную_страницу() {
        BaseTest.baseOpenPage(ConfProperties.getProperty("platform"),8);
//        int d= 1;
    }



}
