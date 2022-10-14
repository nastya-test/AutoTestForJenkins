package cucumber.pageobjects.mainPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.pageobjects.AbstractPage;
import cucumber.pageobjects.NameOfElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.tagName;

public class PopularPage extends AbstractPage {
    //Заголовок блока "Популярное"
    @NameOfElement("Заголовок блока Популярное")
    SelenideElement headerPopularBlock = $("[class *='styles_popularPostsColumn']>[class *='title']");

    //Порядковый номер у всех новостей
    @NameOfElement("Порядковый номер у новости")
    ElementsCollection newsNumberPopular = $$("[href *='media']>[class *='index']");

    //Иконка комментариев
    @NameOfElement("Иконка комментариев у новости")
    ElementsCollection iconOfCommentsPopular = $$("[href *='comments'][class *='styles_root']");

    //Количество комментариев, все 10 комментариев
    @NameOfElement("Количество комментариев у новости")
    ElementsCollection numberOfCommentsPopular = $$("[href *='comments'][class *='styles_root']");

    //Картинка первой новости
    @NameOfElement("Картинка первой новости")
    SelenideElement pictureNewsFirstPopular = $("[class *='styles_image__iaFZw']");

    //Ссылка c картинки первой новости
    @NameOfElement("Ссылка c картинки первой новости")
    SelenideElement LinkPictureNewsFirstPopular = $("[class *='styles_image__iaFZw']").parent();

    //Ссылка с текста первой новости
    @NameOfElement("Текст первой новости")
    SelenideElement TextNewsFirstPopular = $("[class *='titleLinkFeatured']");

    //Блок с новостями, нужен для подсчёта количества новостей
    @NameOfElement("Блок с новостями")
    ElementsCollection newsBlockPopular = $("[class *='popularPostsColumn']>[class *='list']").findAll(tagName("li"));

    //Весь блок Популярное
    @NameOfElement("Блок Популярное")
    SelenideElement popularBlock = $(byId("media-preview-block"));
}
