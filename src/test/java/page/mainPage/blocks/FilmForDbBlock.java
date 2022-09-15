package page.mainPage.blocks;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.regexPattern;
import io.qameta.allure.Step;
import data.model.Film;
import page.mainPage.steps.CommonSteps;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class FilmForDbBlock {

    //Название фильма
    SelenideElement banner =  $("[class *='styles_content']>a>[class *='styles_logo']");

    //Название фильма
    SelenideElement nameFilm =  $("[class *='styles_header']>[class *='styles_title']>[class *='title']> span");

    //Год и ссылка фильма
    SelenideElement hrefAndYear =  $("[class *='styles_years']");

    //Название и ссылка трейлера
    ElementsCollection trailerBlock = $$("[class *='film-trailer']");

    //Название и ссылка трейлера
    ElementsCollection nameAndHrefTrailer = $$("[class *='title__vd']");

    //Год и жанр трейлера
    ElementsCollection yearAndGenreTrailer = $$("[class *='title__vd']+[class *='date']");

    @Step("Добавление нескольких фильмов в список")
    public List<Film> assertManyFilm() {
        ArrayList<Film> listOfFilm = new ArrayList();
        for (int j = 0; j < nameAndHrefTrailer.size(); j++) {
            nameAndHrefTrailer.get(j).scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"end\"}");

            if (!Pattern.matches(regexPattern.regexYearAndGenre(), yearAndGenreTrailer.get(j).getText())) {
                listOfFilm.add(getFilm(nameAndHrefTrailer.get(j), yearAndGenreTrailer.get(j), nameAndHrefTrailer.get(j)));
            }
        }
        System.out.println(listOfFilm);
        return listOfFilm;
    }

    @Step("Добавление фильма с баннера в бд")
    public Film assertFilm() {
        bannerClick();
        return getFilm(nameFilm, hrefAndYear, hrefAndYear);
    }

    @Step("Кликнули на баннер")
    public FilmForDbBlock bannerClick() {
        banner.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"end\"}");
        banner.click();
        return this;
    }

    @Step("Получили название фильма")
    public String getName(SelenideElement nameElement) {
        String name = nameElement.getText();
        return name;
    }

    @Step("Получили год фильма")
    public String getYearAndGenre(SelenideElement yearElement) {
        String yearAndGenre = yearElement.getText();
        return yearAndGenre;
    }

    @Step("Получили ссылку фильма")
    public String getHref(SelenideElement hrefElement) {
        String href = hrefElement.getAttribute("href");
        return href;
    }

    @Step("Получить фильм")
    public Film getFilm(SelenideElement nameElement, SelenideElement yearElement, SelenideElement hrefElement) {
        Film film = new Film();
        film.setName(getName(nameElement));
        film.setYearAndGenre(getYearAndGenre(yearElement));
        film.setLink(getHref(hrefElement));
        return film;
    }


}