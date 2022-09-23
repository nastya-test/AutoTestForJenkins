package test;

import org.testng.annotations.BeforeMethod;
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

    private static final SelenideElement stayButton = $("#stay-button");
    private static final SelenideElement iframe = $(By.xpath("/html/body/div[3]/div[3]/div/div/iframe"));
    private static final SelenideElement elementMainPage = $(".styles_link__KtvyW");
    private static final String platform = ConfProperties.getProperty("platform");
    private static final Integer pageDown = 0;

    @BeforeMethod
    protected static void baseOpenPage() {
        configuration();
        clickStayButton();
        waitMainPage();
    }

    public static void authorized(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginInToTheAccount();
        waitMainPage();
        clickStayButton();
    }

    private static void clickStayButton(){
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


    private static void configuration(){
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

    public static boolean isMobile(){
        boolean mobile;
        if (Objects.equals(ConfProperties.getProperty("platform"), "mobile")){
            mobile=true;
        }
        else {
            mobile=false;
        }
        System.out.println("Web" + mobile);
        return mobile;
    }

}
