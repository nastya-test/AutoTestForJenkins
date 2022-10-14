package cucumber.pageobjects.mainPage;

import com.codeborne.selenide.SelenideElement;
import cucumber.pageobjects.AbstractPage;
import cucumber.pageobjects.NameOfElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends AbstractPage {

    @NameOfElement("Вход в аккаунт")
    public SelenideElement loginButton =  $(".styles_loginButton__LWZQp");

    @NameOfElement("Логин")
    public SelenideElement loginField =  $("#passp-field-login");

    @NameOfElement("Продолжить")
    public SelenideElement signInButton =  $(".Button2_view_action");

    @NameOfElement("Пароль")
    public SelenideElement passwordField =  $("#passp-field-passwd");

    @NameOfElement("Аватар")
    public SelenideElement avatar =  $(".styles_root__42Fk8");

    @NameOfElement("Логин на главной странице")
    public SelenideElement textLoginMainPage =  $(".styles_primaryTitleDefaultAccount__a0_6V");

    @NameOfElement("Главная страница")
    public SelenideElement all  =  $(".styles_root__RPFB8");

    @NameOfElement("Сообщение об ошибке")
    public SelenideElement error  =  $(".Textinput-Hint");
}
