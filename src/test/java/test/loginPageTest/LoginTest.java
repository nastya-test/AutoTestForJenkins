package test.loginPageTest;

import page.authorizationPage.LoginPage;
import io.qameta.allure.Description;
import test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest {
    @BeforeMethod
    public void openPage() {
        BaseTest.baseOpenPage("web",0);
    }

    @Test
    @Description("Успешный вход в систему")
    public void checkLogin(){
        page(LoginPage.class).loginInToTheAccount();
    }
}
