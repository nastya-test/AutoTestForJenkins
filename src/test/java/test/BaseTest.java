package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import com.codeborne.selenide.ex.ElementNotFound;
import config.ConfProperties;
import util.parallelRunning.Mobile;
import util.parallelRunning.PlatformSetup;
import util.parallelRunning.Web;
import java.time.Duration;
import java.util.Objects;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import io.qameta.allure.selenide.AllureSelenide;

public class BaseTest {

    private static final SelenideElement stayButton = $("#stay-button");
    private static final SelenideElement iframe = $(By.xpath("/html/body/div[3]/div/div[3]/div/div/iframe"));
    private static final SelenideElement elementMainPage = $(".styles_link__KtvyW");

    @Step
    private static void clickStayButton(String platforms){
        if (Objects.equals(platforms, "mobile")) {
            System.out.println("Должен быть клик");
            try {
                sleep(5000);
                switchTo().frame(iframe);
                System.out.println("Находимся в айфрейме");
                stayButton.click();
                System.out.println("Кликнули на остаться");
            }
            catch (ElementNotFound exception){
                System.out.println("Нажатие кнопки Остаться не потребовалось");
            }
        }
    }

    @Step
    private static void waitMainPage(){
        elementMainPage.shouldBe(Condition.visible, Duration.ofMinutes(1));
    }


    @Step
    public static boolean isMobile(){
        return Objects.equals(PlatformSetup.getPlatform(), "mobile");
    }

    @Step
    private void configurationParallel(){
        String platform = PlatformSetup.getPlatform();
        WebDriverManager.chromedriver().setup();
        switch (platform.toLowerCase()) {
            case "mobile":
                setWebDriver(new Mobile().createDriver(new DesiredCapabilities()));
                break;
            case "web":
                setWebDriver(new Web().createDriver(new DesiredCapabilities()));
        }

        String url = ConfProperties.getProperty("loginPageUrl");
        open(url);
    }

    @Parameters({"platforms"})
    @BeforeTest
    public void baseOpenPageParallel(String platforms) {
        System.out.println("BASE TEST" + platforms);
        PlatformSetup.setPlatform(platforms);
        configurationParallel();
        clickStayButton(platforms);
        waitMainPage();
    }

    @BeforeMethod
    static void setupAllureReports() {
        System.out.println("Сработал скрин");
        ScreenShooter.captureSuccessfulTests = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }


}
