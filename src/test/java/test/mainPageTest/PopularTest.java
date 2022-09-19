package test.mainPageTest;

import page.mainPage.blocks.PopularBlock;
import io.qameta.allure.Description;
import test.BaseTest;
import config.ConfProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Objects;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

public class PopularTest {

    @BeforeMethod
    public void openPage() {
        BaseTest.baseOpenPage(ConfProperties.getProperty("platform"), 5);
        if (Objects.equals(ConfProperties.getProperty("platform"), "mobile")) {
            PopularBlock popularBlock = new PopularBlock();
            sleep(500);
            popularBlock.mobileButton();
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
