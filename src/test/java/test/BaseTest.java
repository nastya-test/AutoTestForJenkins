package test;

import page.authorizationPage.LoginPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import com.codeborne.selenide.ex.ElementNotFound;
import config.ConfProperties;

import java.time.Duration;
import java.util.Objects;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    static SelenideElement stayButton = $("#stay-button");
    static SelenideElement iframe = $(By.xpath("/html/body/div[3]/div[3]/div/div/iframe"));
    static SelenideElement elementMainPage = $(".styles_link__KtvyW");

    public static void baseOpenPage(String platform) {
        configuration(platform);
        clickStayButton(platform);
        waitMainPage();
    }

    public static void baseOpenPage(String platform, Integer pageDown) {
        configuration(platform);
        clickStayButton(platform);
        waitMainPage();
        pageDown(pageDown);
    }

    public static void authorized(String platform){
        LoginPage loginPage = new LoginPage();
        loginPage.loginInToTheAccount();
        waitMainPage();
        clickStayButton(platform);
    }

    private static void clickStayButton(String platform){
        if (Objects.equals(platform, "mobile")) {
            System.out.println("Должен быть клик");
            try {
                switchTo().frame(iframe);
                stayButton.click();
            }
            catch (ElementNotFound exception){
                System.out.println("Нажатие кнопки Остаться не потребовалось");
            }
        }
    }

    private static void waitMainPage(){
        elementMainPage.shouldBe(Condition.visible, Duration.ofMinutes(1));
    }


    private static void configuration(String platform){
        if (Objects.equals(platform, "mobile")) {
            System.setProperty("chromeoptions.mobileEmulation", "deviceName=Nexus 5");
        }
        Configuration.browserSize= "1024x768";
        String url = ConfProperties.getProperty("loginPageUrl");
        open(url);
    }

    private static void pageDown(Integer pageDown){
        if(pageDown >0){
            for (int j = 0; j < pageDown; j++) {
                elementMainPage.sendKeys(Keys.PAGE_DOWN);
            }
        }
    }
}
