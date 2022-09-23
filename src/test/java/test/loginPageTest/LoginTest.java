package test.loginPageTest;

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
}
