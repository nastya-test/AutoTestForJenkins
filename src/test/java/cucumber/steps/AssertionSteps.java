package cucumber.steps;

import cucumber.pageobjects.MainPage;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.То;
import static com.codeborne.selenide.Selenide.page;
import static cucumber.steps.AbstractSteps.textOfElement;

public class AssertionSteps {
    MainPage mainPage = page(MainPage.class);

    @То("проверяет, что текст элемента {string} соответствует тексту {string}")
    public void проверяетЧтоТекстЭлементаСоответствуетТексту(String element, String text) {
        textOfElement(mainPage.get(element), text);
    }

    @То("проверяет, что элемент {string} отображается")
    public void проверяетЧтоЭлементОтображается(String element) {
    }

    @То("проверяет, что элемент {string} имеет {string} шрифт")
    public void проверяетЧтоЭлементИмеетШрифт(String element, String border) {
    }

    @То("проверяет, что ссылка элемента {string} совпадает с ссылкой элемента {string}")
    public void проверяетЧтоСсылкаЭлементаСовпадаетССсылкойЭлемента(String element1, String element2) {
    }

    @То("проверяет, что элемент {string} содержит {int} блоков")
    public void проверяетЧтоЭлементСодержитБлоков(String element, int countPfBlock) {
    }

    @То("проверяет, что элемент {string} имеет {string} цвет")
    public void проверяетЧтоЭлементИмеетЦвет(String colour) {
    }

    @То("проверяет, что текст элемента {string} соответствует регулярному выражению {string}")
    public void проверяетЧтоТекстЭлементаСоответствуетРегулярномуВыражению(String element, String regex) {
    }

    @То("проверяет, что ссылка элемента {string} соответствует регулярному выражению {string}")
    public void проверяетЧтоСсылкаЭлементаСоответствуетРегулярномуВыражению(String element, String regex) {
    }

    @То("проверяет, что элемент {string} содержит изоображение")
    public void проверяетЧтоЭлементСодержитИзоображение(String element) {
    }

    @И("проверяет, что ссылка элемента {string} совпадает с ссылкой {string}")
    public void проверяетЧтоСсылкаЭлементаСовпадаетССсылкой(String element, String href) {
    }

    @И("проверяет, что у элемента {string} стрелка назад отсутствует, после нажатия стрелки вперед, стрелка назад появляется")
    public void проверяетЧтоУЭлементаСтрелкаНазадОтсутствуетПослеНажатияСтрелкиВпередСтрелкаНазадПоявляется(String element) {
    }
}
