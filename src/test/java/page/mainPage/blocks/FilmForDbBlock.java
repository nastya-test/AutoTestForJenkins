package page.mainPage.blocks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import data.model.Film;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FilmForDbBlock {

    //Название фильма в карусели
    ElementsCollection nameFilmTickets =  $$("[class *='captions']>[class *='title']> span > span");

    //Жанр и год фильма
    ElementsCollection yearAndGenreFilmTickets =  $$("[class *='captions']>[class *='subtitle']>span");

    //Ссылка на фильм
    ElementsCollection hrefFilmTickets =  $$("[class *='captions']");

    //Название фильма в карусели
    SelenideElement nameFilmTicket =  $("[class *='captions']>[class *='title']> span > span");

    //Жанр и год фильма
    SelenideElement yearAndGenreFilmTicket =  $("[class *='captions']>[class *='subtitle']>span");

    //Ссылка на фильм
    SelenideElement hrefFilmTicket =  $("[class *='captions']");


    @Step("Получили название фильма")
    public String getName() {
        String name = nameFilmTicket.getText();
        return name;
    }

    @Step("Получили год и жанр фильма")
    public String getYearAndGenre() {
        String yearAndGenre = yearAndGenreFilmTicket.getText();
        return yearAndGenre;
    }

    @Step("Получили ссылку фильма")
    public String getHref() {
        String href = hrefFilmTicket.getText();
        return href;
    }


    @Step("Проверка, что название корректно. Regex")
    public Film getFilmList() {
        Film film = new Film();
        film.setName(getName());
        film.setYearAndGenre(getYearAndGenre());
        film.setLink(getHref());
        return film;
    }

}
