package page.cucumberStepDefinition;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.То;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static data.constants.iconComment;
import static data.colourPattern.orangeColour;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.tagName;
import static page.mainPage.steps.CommonSteps.*;
import static test.BaseTest.isMobile;

public class PopularStep {
    //Заголовок блока "Популярное"
    SelenideElement headerPopularBlock = $("[class *='styles_popularPostsColumn']>[class *='title']");

    //Кнопка популярное mobile
    ElementsCollection buttonPopularMobile = $$("[id *='media-preview-block']+ div > div > div > [type='button']");

    //Порядковый номер у всех новостей
    ElementsCollection newsNumberPopular = $$("[href *='media']>[class *='index']");

    //Иконка комментариев
    ElementsCollection iconOfCommentsPopular = $$("[href *='comments'][class *='styles_root']");

    //Количество комментариев, все 10 комментариев
    ElementsCollection numberOfCommentsPopular = $$("[href *='comments'][class *='styles_root']");

    //Картинка первой новости
    SelenideElement pictureNewsFirstPopular = $("[class *='styles_image__iaFZw']");

    //Картинка первой новости mobile
    SelenideElement pictureNewsFirstPopularMobile = $("[class *='featuredImage']");

    //Ссылка c картинки первой новости
    SelenideElement LinkPictureNewsFirstPopular = $("[class *='styles_image__iaFZw']").parent();

    //Ссылка c картинки первой новости mobile
    SelenideElement LinkPictureNewsFirstPopularMobile = $("[class *='featuredImage']").parent();

    //Ссылка с текста первой новости
    SelenideElement LinkTextNewsFirstPopular = $("[class *='titleLinkFeatured']");

    //Ссылка с текста первой новости mobile
    SelenideElement LinkTextNewsFirstPopularMobile = $("[class *='featuredTitleLink']");

    //Блок с новостями, нужен для подсчёта количества новостей
    ElementsCollection newsBlockPopular = $("[class *='popularPostsColumn']>[class *='list']").findAll(tagName("li"));

    //Блок с новостями, нужен для подсчёта количества новостей mobile
    ElementsCollection newsBlockPopularMobile = $("[id *='media-preview-block'] + div > div").findAll(tagName("article"));

    //Ссылка с текста первой новости mobile
    SelenideElement scrollButton = $("[class *='featuredCaptions']");

    //Весь блок Популярное
    SelenideElement popularBlock = $(byId("media-preview-block"));

    SelenideElement element;


    @То("проверяет, что у первой новости есть изоображение")
    public void проверяет_что_у_первой_новости_есть_изоображение() {
        if (!isMobile()) {
            element = pictureNewsFirstPopular;
        } else {
            element = pictureNewsFirstPopularMobile;
        }
        element.shouldHave(Condition.image);
    }

    @То("проверяет, название блока Популярное")
    public void проверяет_название_блока_Популярное() {
        if (!isMobile()) {
            element = headerPopularBlock;
        } else {
            element = buttonPopularMobile.get(1);
        }
        nameBlock(element, "Популярное");
    }

    @То("проверяет, что номер новости оранжевого цвета")
    public void проверяет_что_номер_новости_оранжевого_цвета() {
        if (!isMobile()) {
            for (SelenideElement element : newsNumberPopular) {
                assertThat(element.getCssValue("color")).isEqualTo(orangeColour());
            }
        } else {
            System.out.println("Step colourNewsNumberPopular ignored for mobile");
        }
    }

    @То("проверяет, что текст новости жирный")
    public void проверяет_что_текст_новости_жирный() {
        if (!isMobile()) {
            element = LinkTextNewsFirstPopular;
        }
        else{
            element = LinkTextNewsFirstPopularMobile;
        }
        assertThat(element.getCssValue("font-weight")).as("Текст первой новости не жирный").isEqualTo("500");
    }

    @То("проверяет, что в блоке {int} новостей")
    public void проверяет_что_в_блоке_новостей(Integer int1) {
        List<SelenideElement> list;
        if (!isMobile()) {
            list = newsBlockPopular;
        } else {
            list = newsBlockPopularMobile;
        }
        assertThat(list).hasSize(10);
    }

    @То("проверяет, что у новости есть иконка комментирования")
    public void проверяет_что_у_новости_есть_иконка_комментирования() {
        for (SelenideElement element : iconOfCommentsPopular) {
            element.shouldHave(Condition.pseudo(":before", "background-image", iconComment));
        }
    }

    @То("проверяет, что при наведении текст оранжевый")
    public void проверяет_что_при_наведении_текст_оранжевый() {
        if (!isMobile()) {
            LinkTextNewsFirstPopular.hover();
            assertThat(LinkTextNewsFirstPopular.getCssValue("color")).as("При наведении на текст цвет не стал оранжевым").isEqualTo(orangeColour());
        }
        else{
            System.out.println("Step colourHoverNewsPopular ignored for mobile");
        }
    }

    @То("проверяет, что у новости корректное количество комментариев")
    public void проверяет_что_у_новости_корректное_количество_комментариев() {
        for (int i = 0; i < 10; i++) {
            assertCommentRegex(numberOfCommentsPopular.get(i));
        }
    }

    @То("проверяет, что ссылка картинки совпадает с ссылкой текста новости")
    public void проверяет_что_ссылка_картинки_совпадает_с_ссылкой_текста_новости() {
        if (!isMobile()) {
            assertThat(LinkTextNewsFirstPopular.getAttribute("href")).as("Ссылка новости не совпала с цветом картинки").isEqualTo(LinkPictureNewsFirstPopular.getAttribute("href"));
        }
        else{
            assertThat(LinkTextNewsFirstPopularMobile.getAttribute("href")).as("Ссылка новости не совпала с цветом картинки").isEqualTo(LinkPictureNewsFirstPopularMobile.getAttribute("href"));
        }
    }


    @И("скролит к блоку Популярное")
    public void скролит_к_блоку_популярное() {
        bestScroll(popularBlock);
        headerPopularBlock.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
