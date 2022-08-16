package PageObject.AuthorizationPage;

import PageObject.Data.user;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static org.assertj.core.api.Assertions.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    //Кнопка "Вход"
    SelenideElement loginButton =  $(".styles_loginButton__LWZQp");

    //Поле логин
    SelenideElement loginField =  $("#passp-field-login");

    //Кнопка "Войти"
    SelenideElement signInButton =  $(".Button2_view_action");

    //Поле пароль
    SelenideElement passwordField =  $("#passp-field-passwd");

    //Аватар
    SelenideElement avatar =  $(".styles_root__42Fk8");

    //Поле с логином
    SelenideElement textLoginMainPage =  $(".styles_primaryTitleDefaultAccount__a0_6V");

    SelenideElement all  =  $(".styles_root__RPFB8");

    @Step ("Вход в существующий аккаунт")
    public LoginPage loginInToTheAccount(){
        loginButton.click();
        loginField.click();
        loginField.setValue(user.validUserLogin());
        signInButton.click();
        passwordField.click();
        passwordField.setValue(user.validUserPassword());
        signInButton.click();
//        avatar.hover();
//        assertThat(textLoginMainPage.getText()).as("Логин не совпал с введенным ранее").isEqualTo(user.validUserLogin());
//        all.hover();
        return this;
    }
}
