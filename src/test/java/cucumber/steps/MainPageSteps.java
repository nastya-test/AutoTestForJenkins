package cucumber.steps;

import cucumber.pageobjects.MainPage;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.То;
import static com.codeborne.selenide.Selenide.page;
import static cucumber.steps.AbstractSteps.bestScroll;
import static cucumber.steps.AbstractSteps.textOfElement;


public class MainPageSteps {
    MainPage mainPage = page(MainPage.class);

    @И("скролит к элементу {string}")
    public void скролитКЭлементу(String element) {
        bestScroll(mainPage.get(element));
    }


    @Если("наводит на элемент {string}")
    public void наводитНаЭлемент(String arg0) {
    }
}
