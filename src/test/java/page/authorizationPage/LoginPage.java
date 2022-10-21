package page.authorizationPage;

import data.generator.UserGenerator;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;
import static test.BaseTest.isMobile;

public class LoginPage {

    //Кнопка "Вход"
    SelenideElement loginButton =  $("[class *='styles_loginButton']");

    //Поле логин
    SelenideElement loginField =  $("#passp-field-login");

    //Кнопка "Войти"
    SelenideElement signInButton =  $(".Button2_view_action");

    //Поле пароль
    SelenideElement passwordField =  $("#passp-field-passwd");

    //Аватар
    SelenideElement avatar =  $("[class *='styles_defaultAvatar']");

    //Логин на главной странице
    SelenideElement textLoginMainPage =  $("[class *='styles_primaryTitleDefaultAccount']");

    //Кнопка выход
    SelenideElement exit =  $(byText("Выйти"));

    //Лого кинопоиска
    SelenideElement all  =  $(".kinopoisk-header-logo__img");

    @Step ("Клик по входу в аккаунт")
    public LoginPage loginButtonClick() {
        loginButton.click();
        return this;
    }

    @Step ("Ввод логина")
    public LoginPage fillLoginField() {
        loginField.click();
        loginField.setValue(UserGenerator.validUserLogin());
        return this;
    }

    @Step ("Ввод пароля")
    public LoginPage fillPasswordField() {
        passwordField.click();
        passwordField.setValue(UserGenerator.validUserPassword());
        return this;
    }

    @Step ("Клик по продолжить")
    public LoginPage signInButtonClick() {
        signInButton.click();
        return this;
    }

    @Step ("Проверить, что вверху страницы отобразился введенный ранее логин")
    public LoginPage assertSuccessAuthorization() {
        if (!isMobile()) {
            avatar.hover();
            assertThat(textLoginMainPage.getText()).as("Логин не совпал с введенным ранее").isEqualTo(UserGenerator.validUserLogin());
            all.hover();
        } else {
            System.out.println("Step assertSuccessAuthorization ignored for mobile");
        }
        return this;
    }

    @Step ("Вход в существующий аккаунт")
    public LoginPage loginInToTheAccount(){
        loginButtonClick().fillLoginField().signInButtonClick().fillPasswordField().signInButtonClick().assertSuccessAuthorization();
        return this;
    }

    @Step ("Выход из аккаунта")
    public LoginPage  logOutOfAccount(){
        avatar.hover();
        exit.click();
        return this;
    }
}
