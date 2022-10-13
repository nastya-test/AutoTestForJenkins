package cucumber.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.pattern.regexPattern;
import io.cucumber.java.ru.То;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;
import static page.mainPage.steps.CommonSteps.bestScroll;

public class PopoverStep {
    //Название
    SelenideElement nameFilmPopover = $("[class *='movieTitle']");

    //Год фильма в Popover
    SelenideElement yearFilmPopover = $("[class *='year']");

    //Актёры в главных ролях
    ElementsCollection rolesFilmPopover = $("[class *='roles']").findAll("[class *='root']");

    //Подзаголовок в главных ролях
    SelenideElement titleRolesFilmPopover = $("[class *='rolesTitle']");

    //Режисер
    ElementsCollection directorsFilmPopover = $("[class *='styles_directors__i_rI9']").findAll("[class *='styles_root__X6lxw']");

    //Подзаголовок режисер
    SelenideElement titleDirectorsFilmPopover = $("[class *='directorsTitle']");

    //Оригинальное название
    ElementsCollection originNameFilmPopover = $$("[class *='originMovieTitle']");

    //Название фильма в карусели
    ElementsCollection nameFilmCarouselPopover = $$("[class *='styles_captions']>[class *='title']> span > span");

    ElementsCollection nameFilmCarouselPopovers = $$("[class *='styles_captions']>[class *='title'] > span > span");

    //Весь поповер
    SelenideElement popover = $("[class *='popoverVisible']");

    //Весь блок Билеты в кино
    SelenideElement filmTicketsBlock = $(byId("today-in-cinema-block"));

    //Заголовок блока "Билеты в кино"
    SelenideElement headerFilmTicketsBlock =  $("[class *='film-page-section-title']>[href *='afisha/new']");

    @То("проверяет основные свойства поповера")
    public PopoverStep проверяет_основные_свойства_поповера() {
        for (int i = 0; i < nameFilmCarouselPopovers.size(); i++) {
            nameFilmCarouselPopovers.get(i).scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"end\"}");
            sleep(1000);
            displayPopover(i);
            nameFilmPopover(i);
            yearFilmPopover(i);
            actorPopover(i);
            titleDirectorsPopover(i);
            directorsPopover(i);

        }
        return this;
    }

    @Step
    public PopoverStep scrollToFilmTicketsBlock() {
        bestScroll(filmTicketsBlock);
        headerFilmTicketsBlock.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("При наведении появился поповер")
    public PopoverStep displayPopover(int i) {
        for (int j=i; j < i+1; j++) {
            nameFilmCarouselPopovers.get(i).hover();
            popover.shouldBe(Condition.visible);
        }
        return this;
    }

    @Step("Название фильма в поповере соответствует названию фильма в карусели")
    public PopoverStep nameFilmPopover(int i) {
        for (int j=i; j <  i+1; j++) {
            System.out.println(nameFilmPopover.getText());
            assertThat(nameFilmCarouselPopover.get(i).getText()).as("Название в карусели отличается от названия в поповере").isEqualTo(nameFilmPopover.getText());
        }
        return this;
    }

    @Step("Отображется год")
    public PopoverStep yearFilmPopover(int i) {
        for (int j=i; j <  i+1; j++) {
            System.out.println(yearFilmPopover.getText());
            yearFilmPopover.shouldBe(Condition.visible);
        }
        return this;
    }

    @Step("В главных ролях есть актеры")
    public PopoverStep actorPopover(int i) {
        for (int j=i; j <  i+1; j++) {
            Boolean withActor = Pattern.matches(regexPattern.filmWithoutRoles(), nameFilmCarouselPopover.get(i).getText());
            if (!withActor) {
                assertThat(titleRolesFilmPopover.getText()).isEqualTo("В главных ролях:");
                List<SelenideElement> list2 = rolesFilmPopover;
                assertThat(list2.size()).isGreaterThan(0);
                System.out.println(list2.size() + " " + "актёров отобразилось");
            }
        }
        return this;
    }

    @Step("Подзаголовок Режиссёр")
    public PopoverStep titleDirectorsPopover(int i) {
        for (int j=i; j <  i+1; j++) {
            assertThat(titleDirectorsFilmPopover.getText()).isEqualTo("Режиссер:");
        }
        return this;
    }

    @Step("Указан режиссёр")
    public PopoverStep directorsPopover(int i) {
        for (int j=i; j <  i+1; j++) {
            List<SelenideElement> list = directorsFilmPopover;
            assertThat(list.size()).isGreaterThan(0);
            System.out.println(list.size() + " " + "режиссёров отобразилось");
        }
        return this;
    }
}
