package cucumber.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import cucumber.converter.ColourConverter;
import cucumber.converter.ConstantsConverter;
import cucumber.converter.RegexConverter;
import cucumber.pageobjects.MainPage;
import io.cucumber.java.ru.То;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import static cucumber.steps.AbstractSteps.*;
import static page.mainPage.steps.CommonSteps.bestScroll;

public class AssertionSteps {
    MainPage mainPage = page(MainPage.class);

    //Проверки отображения элемента
    @То("проверяет, что элемент {string} отображается")
    public void проверяетЧтоЭлементОтображается(String element) {
        assertVisible(mainPage.get(element));
    }

    @То("проверяет, что элементы {string} отображаются")
    public void проверяетЧтоЭлементыОтображаются(String elements) {
        for (SelenideElement element : mainPage.getCollection(elements)) {
            assertVisible(element);
        }
    }

    //Проверки с цветами
    @То("проверяет, что элемент {string} имеет {string} цвет")
    public void проверяетЧтоЭлементИмеетЦвет(String element, String colour) {
        assertColour(mainPage.get(element), ColourConverter.getColourByName(colour));
    }

    @То("проверяет, что элементы {string} имеют {string} цвет")
    public void проверяетЧтоЭлементыИмеютЦвет(String elements, String colour) {
        for (SelenideElement element : mainPage.getCollection(elements)) {
            assertColour(element, ColourConverter.getColourByName(colour));
        }
    }

    //Проверки с регулярками
    @То("проверяет, что текст элементов {string} соответствует регулярному выражению {string}")
    public void проверяетЧтоТекстЭлементовСоответствуетРегулярномуВыражению(String elements, String regex){
        for (SelenideElement element : mainPage.getCollection(elements)) {
            assertTextRegex(element, RegexConverter.getRegexByName(regex));
        }
    }

    @То("проверяет, что ссылка элементов {string} соответствует регулярному выражению {string}")
    public void проверяетЧтоСсылкаЭлементаСоответствуетРегулярномуВыражению(String elements, String regex) {
        for (SelenideElement element : mainPage.getCollection(elements)) {
            assertLinkRegex(element, RegexConverter.getRegexByName(regex));
        }
    }

    //Проверки с ссылками
    @То("проверяет, что ссылка элемента {string} совпадает с ссылкой {string}")
    public void проверяетЧтоСсылкаЭлементаСовпадаетССсылкой(String element, String href) {
        assertLinkOfElementText(mainPage.get(element), ConstantsConverter.getConstantsByName(href));
    }

    @То("проверяет, что ссылка элемента {string} совпадает с ссылкой элемента {string}")
    public void проверяетЧтоСсылкаЭлементаСовпадаетССсылкойЭлемента(String element1, String element2) {
        assertCompareLinkOfElements(mainPage.get(element1), mainPage.get(element2));
    }

    //Разные проверки
    @То("проверяет, что текст элемента {string} соответствует тексту {string}")
    public void проверяетЧтоТекстЭлементаСоответствуетТексту(String element, String text) {
        assertTextOfElement(mainPage.get(element), text);
    }

    @То("проверяет, что элемент {string} содержит {int} блоков")
    public void проверяетЧтоЭлементСодержитБлоков(String elements, int countPfBlock) {
        assertCountElementCollection(mainPage.getCollection(elements), 10);
    }

    @То("проверяет, что элемент {string} имеет шрифт c font-weight равный {string}")
    public void проверяетЧтоЭлементИмеетШрифтCFontWeightРавный(String element, String fontWeight) {
        assertFontWeight(mainPage.get(element), fontWeight);
    }

    @То("проверяет, что элементы {string} содержат изоображение")
    public void проверяетЧтоЭлементСодержатИзоображение(String element) {
        assertIsImage(mainPage.get(element));
    }

    @То("проверяет, что у элемента {string} стрелка назад отсутствует, после нажатия стрелки вперед, стрелка назад появляется")
    public void проверяетЧтоУЭлементаСтрелкаНазадОтсутствуетПослеНажатияСтрелкиВпередСтрелкаНазадПоявляется(String element) {
    }

    @То("проверяет, что для всех элементов {string} при нажатии на элемент {string} отображается элемент {string} и закрывается при нажатии на элемент {string}")
    public void проверяетЧтоДляВсехЭлементовПриНажатииНаЭлементОтображаетсяЭлементИЗакрываетсяПриНажатииНаЭлемент(String element1, String element2, String element3, String element4) {
        for (int j = 0; j < mainPage.getCollection(element1).size(); j++) {
            bestScroll(mainPage.getCollection(element1).get(j));
            mainPage.getCollection(element1).get(j).click();
            sleep(500);
            mainPage.get(element3).shouldBe(Condition.visible);
            mainPage.get(element3).click();
        }
    }
}
