package page.mainPage.blocks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.regexPattern;
import db.services.DbInteraction;
import io.qameta.allure.Step;
import data.model.Film;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static page.mainPage.steps.CommonSteps.bestScroll;

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

    //Заголовок блока
    SelenideElement headerTrailerBlock = $(byText("Новые трейлеры"));

    //Весь блок трейлеры
    SelenideElement trailersBlock = $(byId("new-trailers-block"));

    @Step("Подскролл к блоку")
    public FilmForDbBlock scrollToTrailer() {
        bestScroll(trailersBlock);
        headerTrailerBlock.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Добавление нескольких фильмов в список, у которых год и жанр некорректный")
    public List<Film> assertManyFilm() {
        scrollToTrailer();
        ArrayList<Film> listOfFilm = new ArrayList();
        for (int j = 0; j < nameAndHrefTrailer.size(); j++) {
            bestScroll(nameAndHrefTrailer.get(j));

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
        bestScroll(banner);
        banner.click();
        return this;
    }

    @Step("Получили название фильма")
    public String getName(SelenideElement nameElement) {
        return nameElement.getText();
    }

    @Step("Получили год фильма")
    public String getYearAndGenre(SelenideElement yearElement) {
        return yearElement.getText();
    }

    @Step("Получили ссылку фильма")
    public String getHref(SelenideElement hrefElement) {
        return hrefElement.getAttribute("href");
    }

    @Step("Получить фильм")
    public Film getFilm(SelenideElement nameElement, SelenideElement yearElement, SelenideElement hrefElement) {
        Film film = new Film();
        film.setName(getName(nameElement));
        film.setYearAndGenre(getYearAndGenre(yearElement));
        film.setLink(getHref(hrefElement));
        return film;
    }

    @Step("Получаем все названия фильмов из блока Новые трейлеры с сайта")
    public List<String> getNameFilmsFromSite() {
        scrollToTrailer();
        List<String> nameOfFilmsFromSite = new ArrayList();
        for (int j = 0; j < nameAndHrefTrailer.size(); j++) {
            bestScroll(nameAndHrefTrailer.get(j));
            nameOfFilmsFromSite.add(nameAndHrefTrailer.get(j).getText());
        }
        System.out.println(nameOfFilmsFromSite);
        return nameOfFilmsFromSite;
    }

    private DbInteraction dbInteraction = new DbInteraction();

    @Step("Получаем все названия фильмов из блока Новые трейлеры из бд")
    public List<String> getNameFilmsFromDB() {
        List<String> nameOfFilmFromDB = new ArrayList();
        nameOfFilmFromDB = dbInteraction.getNameOfFilm();
        System.out.println(nameOfFilmFromDB);
        return nameOfFilmFromDB;
    }

    @Step("Сравниваем фильмы из бд с фильмами с сайта")
    public void compareNameOfFilms() {
        List<String> DbList = getNameFilmsFromDB();
        List<String> SiteList = getNameFilmsFromSite();

        List<String> result1 = DbList
                .stream()
                .filter(SiteList::contains)
                .collect(Collectors.toList());

        List<String> result2 = DbList.stream()
                .filter(aObject -> !SiteList.contains(aObject))
                .collect(Collectors.toList());

        List<String> result3 = SiteList.stream()
                .filter(aObject -> !DbList.contains(aObject))
                .collect(Collectors.toList());

        System.out.println("Фильмы, которые есть и в бд, и на сайте: " + result1);
        System.out.println("Фильмы, которые есть в бд, но нет на сайте: " + result2);
        System.out.println("Фильмы, которые есть на сайте, но нет в бд: " + result3);
    }



}
