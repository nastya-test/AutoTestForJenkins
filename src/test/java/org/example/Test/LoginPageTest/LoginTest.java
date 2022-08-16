package org.example.Test.LoginPageTest;

import PageObject.AuthorizationPage.LoginPage;
import io.qameta.allure.Description;
import org.example.BaseTest;
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
