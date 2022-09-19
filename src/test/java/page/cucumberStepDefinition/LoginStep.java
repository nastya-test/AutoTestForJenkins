package page.cucumberStepDefinition;

import com.codeborne.selenide.SelenideElement;
import data.UserGenerator;
import data.model.User;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.То;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginStep {
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

    SelenideElement error  =  $(".Textinput-Hint");

    @Дано("переходит на страницу входа в аккаунт")
    public void переходит_на_страницу_входа_в_аккаунт() {
        loginButton.click();
    }

    @Дано("вводит существующий логин")
    public void вводит_существующий_логин() {
        loginField.click();
        loginField.setValue(UserGenerator.validUserLogin());
    }

    @Дано("нажимает продолжить")
    public void нажимает_продолжить() {
        signInButton.click();
    }

    @Дано("вводит пароль")
    public void вводит_пароль() {
        passwordField.click();
        passwordField.setValue(UserGenerator.validUserPassword());
    }

    @То("пользователь вошел в аккаунт")
    public void пользователь_вошел_в_аккаунт() {
        avatar.hover();
        assertThat(textLoginMainPage.getText()).as("Логин не совпал с введенным ранее").isEqualTo(UserGenerator.validUserLogin());
        all.hover();
    }


    @То("отобразилось сообщение об ошибке")
    public void отобразилось_сообщение_об_ошибке() {
        assertThat(error.getText()).isEqualTo("Такой логин не подойдет");
    }

    @И("вводит в поле логин {string}")
    public void вводитВПолеЛогин(String arg0) {
        loginField.click();
        loginField.setValue(arg0);
    }
}
