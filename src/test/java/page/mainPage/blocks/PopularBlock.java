package page.mainPage.blocks;

import java.time.Duration;
import java.util.List;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static data.pattern.linkPattern.iconComment;
import static data.pattern.colourPattern.orangeColour;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.tagName;
import static page.mainPage.steps.CommonSteps.*;
import static test.BaseTest.isMobile;

public class PopularBlock {

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

    @Step
    public PopularBlock scrollToPopularBlock() {
        bestScroll(popularBlock);
        headerPopularBlock.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Mobile. Переход на вкладку популярное")
    public PopularBlock mobileButton() {
        buttonPopularMobile.get(1).scrollIntoView("{behavior: \"instant\", block: \"center\"}").shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Назвавние блока")
    public PopularBlock headerTextPopularBlock() {
        if (!isMobile()) {
            element = headerPopularBlock;
        } else {
            element = buttonPopularMobile.get(1);
        }
        nameBlock(element, "Популярное");
        return this;
    }

    //Проверки для первой новости
    @Step("У первой новости есть изоображение")
    public PopularBlock imgPopular() {
        if (!isMobile()) {
            element = pictureNewsFirstPopular;
        } else {
            element = pictureNewsFirstPopularMobile;
        }
        element.shouldHave(Condition.image);
        return this;
    }

    @Step("При наведении текст становится оранжевым")
    public PopularBlock colourHoverNewsPopular() {
        if (!isMobile()) {
            LinkTextNewsFirstPopular.hover();
            assertThat(LinkTextNewsFirstPopular.getCssValue("color")).as("При наведении на текст цвет не стал оранжевым").isEqualTo(orangeColour());
        }
        else{
            System.out.println("Step colourHoverNewsPopular ignored for mobile");
        }
        return this;
    }

    @Step("Ссылка новости совпадет с ссылкой картинки")
    public PopularBlock linkNewsPopular() {
        if (!isMobile()) {
            assertThat(LinkTextNewsFirstPopular.getAttribute("href")).as("Ссылка новости не совпала с цветом картинки").isEqualTo(LinkPictureNewsFirstPopular.getAttribute("href"));
        }
        else{
            assertThat(LinkTextNewsFirstPopularMobile.getAttribute("href")).as("Ссылка новости не совпала с цветом картинки").isEqualTo(LinkPictureNewsFirstPopularMobile.getAttribute("href"));
        }
        return this;
    }

    @Step("Текст первой новости жирный")
    public PopularBlock boldNewsPopular() {
        if (!isMobile()) {
            element = LinkTextNewsFirstPopular;
        }
        else{
            element = LinkTextNewsFirstPopularMobile;
        }
        assertThat(element.getCssValue("font-weight")).as("Текст первой новости не жирный").isEqualTo("500");
        return this;
    }

    //Проверки для всех новостей
    @Step("Порядковый номер у новости оранжевого цвета")
    public PopularBlock colourNewsNumberPopular() {
        if (!isMobile()) {
            for (SelenideElement element : newsNumberPopular) {
                assertThat(element.getCssValue("color")).isEqualTo(orangeColour());
            }
        } else {
            System.out.println("Step colourNewsNumberPopular ignored for mobile");
        }
        return this;
    }

    @Step("Корректное количество комментариев у новости")
    public PopularBlock commentNewsRegexPopular() {
        for (int i = 0; i < 10; i++) {
            assertCommentRegex(numberOfCommentsPopular.get(i));
        }
        return this;
    }

    @Step("Иконка комментирования")
    public PopularBlock iconCommentNewsPopular() {
        for (SelenideElement element : iconOfCommentsPopular) {
            element.shouldHave(Condition.pseudo(":before", "background-image", iconComment));
        }
        return this;
    }

    @Step("Подсчёт количества новостей")
    public PopularBlock countNewsPopular() {
        List<SelenideElement> list;
        if (!isMobile()) {
            list = newsBlockPopular;
        } else {
            list = newsBlockPopularMobile;
        }
        assertThat(list).hasSize(10);
        return this;
    }

}
