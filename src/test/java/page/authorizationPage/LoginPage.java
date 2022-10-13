package page.authorizationPage;

import data.generator.UserGenerator;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;
import static test.BaseTest.isMobile;

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
}
