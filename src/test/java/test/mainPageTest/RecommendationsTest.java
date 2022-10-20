package test.mainPageTest;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;
import page.authorizationPage.LoginPage;
import page.mainPage.blocks.RecommendationsBlock;
import io.qameta.allure.Description;
import test.BaseTest;

import static com.codeborne.selenide.Selenide.page;

public class RecommendationsTest extends BaseTest {

    @BeforeMethod
    public void scrolling(){
        page(RecommendationsBlock.class).scrollToRecommendationsBlock();
    }

    @AfterMethod
    @Description("Выход из аккаунта")
    public void afterExit(){
        page(LoginPage.class).exitAccount();
    }

    @BeforeMethod
    @Description("Вход в аккаунта")
    public void login(){
        page(LoginPage.class).loginInToTheAccount();
    }

    @Test
    @Description("Regex. Название, год и жанр, ссылка, рейтинг. + у сниппета есть постер")
    public void checkRegexRecommend() {
        page(RecommendationsBlock.class)
                .imgRecommend()
                .assertNameRecommendRegex()
                .assertYearAndGenreRecommendRegex()
                .assertHrefRecommendRegex()
                .assertRatingRecommendRegex();
    }

    @Test
    @Description("Название блока и ссылка")
    public void checkHeaderRecommendBlock() {
        page(RecommendationsBlock.class)
                .nameRecommendationsBlock()
                .hrefRecommendationsBlock();
    }

    @Test
    @Description("Скролл")
    public void checkScroll() {
        page(RecommendationsBlock.class)
                .scrollRecommend();
    }
}
