package cucumber.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.tagName;

@NameOfPage("Заголовок блока Популярное")
public class MainPage extends AbstractPage{
    //Заголовок блока "Популярное"
    @NameOfElement("Заголовок блока Популярное")
    SelenideElement headerPopularBlock = $("[class *='styles_popularPostsColumn']>[class *='title']");

    //Кнопка популярное mobile
    @NameOfElement("Вкладка популярное в мобильной версии")
    ElementsCollection buttonPopularMobile = $$("[id *='media-preview-block']+ div > div > div > [type='button']");

    //Порядковый номер у всех новостей
    @NameOfElement("Порядковый номер у новостей")
    ElementsCollection newsNumberPopular = $$("[href *='media']>[class *='index']");

    //Иконка комментариев
    @NameOfElement("Иконка комментариев у новостей")
    ElementsCollection iconOfCommentsPopular = $$("[href *='comments'][class *='styles_root']");

    //Количество комментариев, все 10 комментариев
    @NameOfElement("Количество комментариев у новости")
    ElementsCollection numberOfCommentsPopular = $$("[href *='comments'][class *='styles_root']");

    //Картинка первой новости
    @NameOfElement("Картинка первой новости")
    SelenideElement pictureNewsFirstPopular = $("[class *='styles_image__iaFZw']");

    //Картинка первой новости mobile
    @NameOfElement("Картинка первой новости в мобильной версии")
    SelenideElement pictureNewsFirstPopularMobile = $("[class *='featuredImage']");

    //Ссылка c картинки первой новости
    @NameOfElement("Ссылка c картинки первой новости")
    SelenideElement LinkPictureNewsFirstPopular = $("[class *='styles_image__iaFZw']").parent();

    //Ссылка c картинки первой новости mobile
    @NameOfElement("Ссылка c картинки первой новости в мобильной версии")
    SelenideElement LinkPictureNewsFirstPopularMobile = $("[class *='featuredImage']").parent();

    //Ссылка с текста первой новости
    @NameOfElement("Текст первой новости")
    SelenideElement TextNewsFirstPopular = $("[class *='titleLinkFeatured']");

    //Ссылка с текста первой новости mobile
    @NameOfElement("Ссылка с текста первой новости mobile в мобильной версии")
    SelenideElement LinkTextNewsFirstPopularMobile = $("[class *='featuredTitleLink']");

    //Блок с новостями, нужен для подсчёта количества новостей
    @NameOfElement("Блок с новостями")
    ElementsCollection newsBlockPopular = $("[class *='popularPostsColumn']>[class *='list']").findAll(tagName("li"));

    //Блок с новостями, нужен для подсчёта количества новостей mobile
    @NameOfElement("Блок с новостями в мобильной версии")
    ElementsCollection newsBlockPopularMobile = $("[id *='media-preview-block'] + div > div").findAll(tagName("article"));

    //Ссылка с текста первой новости mobile
    @NameOfElement("Ссылка с текста первой новости в мобильной версии")
    SelenideElement scrollButton = $("[class *='featuredCaptions']");

    //Весь блок Популярное
    @NameOfElement("Блок Популярное")
    SelenideElement popularBlock = $(byId("media-preview-block"));

}
