package cucumber.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.tagName;

@NameOfPage("Заголовок блока Популярное")
public class MainPage extends AbstractPage{

/**Блок популярное*/

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


/**Блок Билеты в кино*/
    //Заголовок блока "Билеты в кино"
    @NameOfElement("Заголовок блока Билеты в кино")
    SelenideElement headerFilmTicketsBlock =  $("[class *='film-page-section-title']>[href *='afisha/new']");

    //Название фильма в карусели
    @NameOfElement("Название фильма в карусели")
    ElementsCollection nameFilmTickets =  $$("[class *='captions']>[class *='title']> span > span");

    //Жанр и год фильма
    @NameOfElement("Жанр и год фильма")
    ElementsCollection yearAndGenreFilmTickets =  $$("[class *='captions']>[class *='subtitle']>span");

    //Ссылка на фильм
    @NameOfElement("Ссылка на фильм")
    ElementsCollection hrefFilmTickets =  $$("[class *='styles_captions__9Azea']");

    //Рейтинг фильма
    @NameOfElement("Рейтинг фильма")
    ElementsCollection ratingFilmTickets =  $$("[class *='ratingPosterNameplate__G2BsG']");

    //Кнопка вперед
    @NameOfElement("Кнопка вперед")
    SelenideElement  forwardArrowTickets =  $("[id ='today-in-cinema-block'] + div > section > div > [class *='carousel'] >[class *='iconRightDir']");

    //Кнопка назад
    @NameOfElement("Кнопка назад")
    SelenideElement  backArrowTickets =  $("[id ='today-in-cinema-block'] + div > section > div > [class *='carousel'] > [class *='iconLeftDir']");

    @NameOfElement("")
    ElementsCollection iconTickets = $$("[class *='styles_nameplate__Ei1aO']");

    //Ссылка билеты в кино у сниппета в карусели
    @NameOfElement("")
    ElementsCollection  hrefIconTickets =  $$("[class *='styles_nameplate__Ei1aO']");

    //Текст "Билеты" в кино у сниппета в карусели
    @NameOfElement("")
    ElementsCollection  textIconTickets =  $$("[class *='labelPlaceholder']+[class *='labelVisible']");

    //Маленькая иконка
    @NameOfElement("")
    ElementsCollection  smallIconTickets =  $$("[class *='styles_icon__S5pZJ']");

    //Постер изоображение
    @NameOfElement("")
    ElementsCollection posterImgTickets =  $$("[class *='posterLink']>[class *='poster']");

    //Весь блок Билеты в кино
    @NameOfElement("")
    SelenideElement filmTicketsBlock = $(byId("today-in-cinema-block"));

}
