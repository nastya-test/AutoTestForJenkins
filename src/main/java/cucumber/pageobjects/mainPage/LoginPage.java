package cucumber.pageobjects.mainPage;

import com.codeborne.selenide.SelenideElement;
import cucumber.pageobjects.AbstractPage;
import cucumber.pageobjects.NameOfElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends AbstractPage {

    @NameOfElement("Вход в аккаунт")
    SelenideElement loginButton =  $(".styles_loginButton__LWZQp");

    @NameOfElement("Логин")
    SelenideElement loginField =  $("#passp-field-login");

    @NameOfElement("Продолжить")
    SelenideElement signInButton =  $(".Button2_view_action");

    @NameOfElement("Пароль")
    SelenideElement passwordField =  $("#passp-field-passwd");

    @NameOfElement("Аватар")
    SelenideElement avatar =  $(".styles_root__42Fk8");

    @NameOfElement("Логин на главной странице")
    SelenideElement textLoginMainPage =  $(".styles_primaryTitleDefaultAccount__a0_6V");

    @NameOfElement("Главная страница")
    SelenideElement all  =  $(".styles_root__RPFB8");
}
