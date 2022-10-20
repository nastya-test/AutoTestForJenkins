package test.loginPageTest;

import org.testng.annotations.AfterTest;
import page.authorizationPage.LoginPage;
import io.qameta.allure.Description;
import test.BaseTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest extends BaseTest{

    @Test
    @Description("Успешный вход в систему")
    public void checkLogin(){
        page(LoginPage.class).loginInToTheAccount();
    }

    @AfterTest
    @Description("Выход из аккаунта")
    public void afterExit(){
        page(LoginPage.class).exitAccount();
    }
}
