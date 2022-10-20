package test.mainPageTest;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import page.mainPage.blocks.PopularBlock;
import io.qameta.allure.Description;
import test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

public class PopularTest extends BaseTest{

    @BeforeMethod
    public void openPage() {
        //BaseTest.baseOpenPage();
        page(PopularBlock.class).scrollToPopularBlock();
        if (isMobile()) {
            sleep(500);
            page(PopularBlock.class).mobileButton();
        }
    }

    @Test
    @Description("У первой новости: есть изоображение, текст новости жирный, при наведении текст оранжевый, ссылка картинки совпадает с ссылкой текста новости")
    public void checkFirstNews() {
        page(PopularBlock.class)
                .imgPopular()
                .boldNewsPopular()
                .colourHoverNewsPopular()
                .linkNewsPopular();
    }

    @Test
    @Description("Название блока Популярное, в блоке 10 новостей")
    public void checkPopularBlock() {
        page(PopularBlock.class)
                .headerTextPopularBlock()
                .countNewsPopular();
    }

    @Test
    @Description("У новостей оранжевый цвет, есть иконка комментирования, корректное количесвто комментариев")
    public void checkNewsPopular() {
        page(PopularBlock.class)
                .colourNewsNumberPopular()
                .commentNewsRegexPopular()
                .iconCommentNewsPopular();
    }
}
