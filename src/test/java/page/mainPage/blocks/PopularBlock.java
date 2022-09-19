package page.mainPage.blocks;

import java.util.List;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;
import static data.Constants.iconComment;
import static data.colourPattern.orangeColour;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.tagName;
import static page.mainPage.steps.CommonSteps.assertCommentRegex;
import static page.mainPage.steps.CommonSteps.nameBlock;

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

    //String iconComment="url(\"data:image/svg+xml;charset=utf-8,%3Csvg xmlns='http://www.w3.org/2000/svg' width='18' height='18'%3E%3Cpath fill-rule='evenodd' d='M2.25 13.393V3.75h13.5v9.643h-4.821L6.107 17.25v-3.857H2.25z' opacity='.1'/%3E%3C/svg%3E\")";

    @Step("Mobile. Переход на вкладку популярное")
    public PopularBlock mobileButton() {
        buttonPopularMobile.get(1).scrollIntoView("{behavior: \"instant\", block: \"center\"}").shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Назвавние блока")
    public PopularBlock headerTextPopularBlock(String platform) {
        switch (platform) {
            case "web":
                nameBlock(headerPopularBlock, "Популярное");
                break;

            case "mobile":
                nameBlock(buttonPopularMobile.get(1), "Популярное");
                break;
        }
        return this;
    }

    //Проверки для первой новости
    @Step("У первой новости есть изоображение")
    public PopularBlock imgPopular(String platform) {
        switch (platform) {
            case "web":
                pictureNewsFirstPopular.shouldHave(Condition.image);
                break;

            case "mobile":
                pictureNewsFirstPopularMobile.shouldHave(Condition.image);
                break;
        }

        return this;
    }

    @Step("При наведении текст становится оранжевым")
    public PopularBlock colourHoverNewsPopular(String platform) {
        switch (platform) {
            case "web":
                LinkTextNewsFirstPopular.hover();
                assertThat(LinkTextNewsFirstPopular.getCssValue("color")).as("При наведении на текст цвет не стал оранжевым").isEqualTo(orangeColour());
                break;

            case "mobile":
                System.out.println("Step colourHoverNewsPopular ignored for mobile");
                break;
        }

        return this;
    }

    @Step("Ссылка новости совпадет с ссылкой картинки")
    public PopularBlock linkNewsPopular(String platform) {
        switch (platform) {
            case "web":
                assertThat(LinkTextNewsFirstPopular.getAttribute("href")).as("Ссылка новости не совпала с цветом картинки").isEqualTo(LinkPictureNewsFirstPopular.getAttribute("href"));
                break;
            case "mobile":
                assertThat(LinkTextNewsFirstPopularMobile.getAttribute("href")).as("Ссылка новости не совпала с цветом картинки").isEqualTo(LinkPictureNewsFirstPopularMobile.getAttribute("href"));
                break;
        }

        return this;
    }

    @Step("Текст первой новости жирный")
    public PopularBlock boldNewsPopular(String platform) {
        switch (platform) {
            case "web":
                assertThat(LinkTextNewsFirstPopular.getCssValue("font-weight")).as("Текст первой новости не жирный").isEqualTo("500");
                break;
            case "mobile":
                assertThat(LinkTextNewsFirstPopularMobile.getCssValue("font-weight")).as("Текст первой новости не жирный").isEqualTo("500");
                break;
        }
        return this;
    }

    //Проверки для всех новостей
    @Step("Порядковый номер у новости оранжевого цвета")
    public PopularBlock colourNewsNumberPopular(String platform) {
        switch (platform) {
            case "web":
                for (SelenideElement element : newsNumberPopular) {
                    assertThat(element.getCssValue("color")).isEqualTo(orangeColour());
                }
                break;
            case "mobile":
                System.out.println("Step colourNewsNumberPopular ignored for mobile");
                break;
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
    public PopularBlock countNewsPopular(String platform) {

        switch (platform) {
            case "web":
                List<SelenideElement> list1 = newsBlockPopular;
                assertThat(list1).hasSize(10);
                break;

            case "mobile":
                List<SelenideElement> list2 = newsBlockPopularMobile;
                assertThat(list2).hasSize(10);
                break;
        }

        return this;
    }

}
