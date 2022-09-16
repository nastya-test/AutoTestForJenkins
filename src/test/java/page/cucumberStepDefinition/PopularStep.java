package page.cucumberStepDefinition;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.colourPattern;
import data.regexPattern;
import io.cucumber.java.ru.То;
import page.mainPage.steps.CommonSteps;
import java.util.List;
import java.util.regex.Pattern;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.tagName;

public class PopularStep {
    //Заголовок блока "Популярное"
    SelenideElement headerPopularBlock = $("[class *='styles_popularPostsColumn']>[class *='title']");

    //Порядковый номер у всех новостей
    ElementsCollection newsNumberPopular = $$("[href *='media']>[class *='index']");

    //Иконка комментариев
    ElementsCollection iconOfCommentsPopular = $$("[href *='comments'][class *='styles_root']");

    //Количество комментариев, все 10 комментариев
    ElementsCollection numberOfCommentsPopular = $$("[href *='comments'][class *='styles_root']");

    //Картинка первой новости
    SelenideElement pictureNewsFirstPopular = $("[class *='styles_image__iaFZw']");

    //Ссылка c картинки первой новости
    SelenideElement LinkPictureNewsFirstPopular = $("[class *='styles_image__iaFZw']").parent();

    //Ссылка с текста первой новости
    SelenideElement LinkTextNewsFirstPopular = $("[class *='titleLinkFeatured']");

    //Блок с новостями, нужен для подсчёта количества новостей
    ElementsCollection newsBlockPopular = $("[class *='popularPostsColumn']>[class *='list']").findAll(tagName("li"));

    @То("проверяет, что у первой новости есть изоображение")
    public void проверяет_что_у_первой_новости_есть_изоображение() {
        pictureNewsFirstPopular.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"end\"}").shouldHave(Condition.image);
    }

    @То("проверяет, название блока Популярное")
    public void проверяет_название_блока_Популярное() {
        CommonSteps.nameBlock(headerPopularBlock, "Популярное");
    }

    @То("проверяет, что номер новости оранжевого цвета")
    public void проверяет_что_номер_новости_оранжевого_цвета() {
        for (SelenideElement element : newsNumberPopular) {
            assertThat(element.getCssValue("color")).isEqualTo(colourPattern.orangeColour());
        }
    }

    @То("проверяет, что текст новости жирный")
    public void проверяет_что_текст_новости_жирный() {
        assertThat(LinkTextNewsFirstPopular.getCssValue("font-weight")).as("Текст первой новости не жирный").isEqualTo("500");
    }

    @То("проверяет, что в блоке {int} новостей")
    public void проверяет_что_в_блоке_новостей(Integer int1) {
        List<SelenideElement> list1 = newsBlockPopular;
        assertThat(list1).hasSize(int1);
    }

    @То("проверяет, что у новости есть иконка комментирования")
    public void проверяет_что_у_новости_есть_иконка_комментирования() {
        for (SelenideElement element : iconOfCommentsPopular) {
            element.shouldHave(Condition.pseudo(":before", "background-image", "url(\"data:image/svg+xml;charset=utf-8,%3Csvg xmlns='http://www.w3.org/2000/svg' width='18' height='18'%3E%3Cpath fill-rule='evenodd' d='M2.25 13.393V3.75h13.5v9.643h-4.821L6.107 17.25v-3.857H2.25z' opacity='.1'/%3E%3C/svg%3E\")"));
        }
    }

    @То("проверяет, что при наведении текст оранжевый")
    public void проверяет_что_при_наведении_текст_оранжевый() {
        LinkTextNewsFirstPopular.hover();
        String colourExpected1 = LinkTextNewsFirstPopular.getCssValue("color");
        assertThat(colourExpected1).as("При наведении на текст цвет не стал оранжевым").isEqualTo(colourPattern.orangeColour());
    }

    @То("проверяет, что у новости корректное количество комментариев")
    public void проверяет_что_у_новости_корректное_количество_комментариев() {
        for (int i = 0; i < 10; i++) {
            Boolean regComment = Pattern.matches(regexPattern.commentNewsPopular(), numberOfCommentsPopular.get(i).getText());
            assertThat(regComment).as("Отображается неверное количество комментариев").isTrue();
            System.out.println(numberOfCommentsPopular.get(i).getText());
        }
    }

    @То("проверяет, что ссылка картинки совпадает с ссылкой текста новости")
    public void проверяет_что_ссылка_картинки_совпадает_с_ссылкой_текста_новости() {
        assertThat(LinkTextNewsFirstPopular.getAttribute("href")).as("Ссылка новости не совпала с цветом картинки").isEqualTo(LinkPictureNewsFirstPopular.getAttribute("href"));
    }


}
