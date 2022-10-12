package cucumber.steps;

import cucumber.pageobjects.MainPage;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.То;
import static com.codeborne.selenide.Selenide.page;
import static cucumber.steps.AbstractSteps.bestScroll;
import static cucumber.steps.AbstractSteps.textOfElement;


public class MainPageSteps {
    MainPage mainPage = page(MainPage.class);

    @То("проверяет, что текст элемента {string} соответствует тексту {string}")
    public void проверяетЧтоТекстЭлементаСоответствуетТексту(String element, String text) {
        textOfElement(mainPage.get(element), text);
    }

    @И("скролит к элементу {string}")
    public void скролитКЭлементу(String element) {
        bestScroll(mainPage.get(element));
    }

    @То("проверяет, что {string} отображается")
    public void проверяетЧтоОтображается(String arg0) {
    }

    @И("проверяет, что {string} имеет жирный шрифт")
    public void проверяетЧтоИмеетЖирныйШрифт(String arg0) {
    }

    @И("проверяет, что при наведении на {string} цвет становится оранжевым")
    public void проверяетЧтоПриНаведенииНаЦветСтановитсяОранжевым(String arg0) {
    }

    @И("проверяет, что ссылка {string} совпадает с ссылкой {string}")
    public void проверяетЧтоСсылкаСовпадаетССсылкой(String arg0, String arg1) {
    }

    @И("проверяет, что {string} содержит {int} новостей")
    public void проверяетЧтоСодержитНовостей(String arg0, int arg1) {
    }

    @То("проверяет, что {string} оранжевого цвета")
    public void проверяетЧтоОранжевогоЦвета(String arg0) {
    }

    @То("проверяет, что {string} соответствует {string}")
    public void проверяетЧтоСоответствует(String arg0, String arg1) {
    }
}
