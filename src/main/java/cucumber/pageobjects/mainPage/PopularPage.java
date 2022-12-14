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

    @NameOfElement("Заголовок блока Популярное")
    public SelenideElement headerPopularBlock = $("[class *='styles_popularPostsColumn']>[class *='title']");

    @NameOfElement("Порядковый номер у новости")
    public ElementsCollection newsNumberPopular = $$("[href *='media']>[class *='index']");

    @NameOfElement("Иконка комментариев у новости")
    public ElementsCollection iconOfCommentsPopular = $$("[href *='comments'][class *='styles_root']");

    @NameOfElement("Количество комментариев у новости")
    public ElementsCollection numberOfCommentsPopular = $$("[href *='comments'][class *='styles_root']");

    @NameOfElement("Картинка первой новости")
    public SelenideElement pictureNewsFirstPopular = $("[class *='styles_image__iaFZw']");

    @NameOfElement("Ссылка c картинки первой новости")
    public SelenideElement LinkPictureNewsFirstPopular = $("[class *='styles_image__iaFZw']").parent();

    @NameOfElement("Текст первой новости")
    public SelenideElement TextNewsFirstPopular = $("[class *='titleLinkFeatured']");

    @NameOfElement("Блок с новостями")
    public ElementsCollection newsBlockPopular = $("[class *='popularPostsColumn']>[class *='list']").findAll(tagName("li"));

    @NameOfElement("Блок Популярное")
    public SelenideElement popularBlock = $(byId("media-preview-block"));
}
