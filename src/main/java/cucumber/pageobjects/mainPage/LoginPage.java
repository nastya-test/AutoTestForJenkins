package cucumber.pageobjects.mainPage;

import com.codeborne.selenide.SelenideElement;
import cucumber.pageobjects.AbstractPage;
import cucumber.pageobjects.NameOfElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends AbstractPage {

    @NameOfElement("Вход в аккаунт")
    public static SelenideElement loginButton =  $(".styles_loginButton__LWZQp");

    @NameOfElement("Логин")
    public static SelenideElement loginField =  $("#passp-field-login");

    @NameOfElement("Продолжить")
    public static SelenideElement signInButton =  $(".Button2_view_action");

    @NameOfElement("Пароль")
    public static SelenideElement passwordField =  $("#passp-field-passwd");

    @NameOfElement("Аватар")
    public static SelenideElement avatar =  $("[class *='styles_defaultAvatar']");

    @NameOfElement("Логин на главной странице")
    public static SelenideElement textLoginMainPage =  $("[class *='styles_primaryTitleDefaultAccount']");

    @NameOfElement("Главная страница")
    public static SelenideElement all  =  $(".kinopoisk-header-logo__img");

    @NameOfElement("Сообщение об ошибке")
    public static SelenideElement error  =  $(".Textinput-Hint");

    @NameOfElement("Вход по почте")
    public static SelenideElement mail =  $("[class *='AuthLoginInputToggle-type']>[class *='Button2']");

}
