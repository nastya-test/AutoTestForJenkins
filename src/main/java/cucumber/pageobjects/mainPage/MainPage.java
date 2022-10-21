package cucumber.pageobjects.mainPage;

import com.codeborne.selenide.SelenideElement;
import cucumber.pageobjects.AbstractPage;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends AbstractPage {
    public static final SelenideElement elementMainPage = $(".kinopoisk-header-logo__img");

}
