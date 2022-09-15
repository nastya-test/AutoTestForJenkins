package test.loginPageTest;

import page.authorizationPage.LoginPage;
import io.qameta.allure.Description;
import test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    @BeforeMethod
    public void openPage() {
        BaseTest.baseOpenPage("web",0);
    }

    @Test
    @Description("Тест входа в систему")
    public void checkLogin(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginInToTheAccount();
    }
}
