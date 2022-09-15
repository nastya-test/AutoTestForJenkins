package test.mainPageTest;

import page.mainPage.blocks.PopularBlock;
import io.qameta.allure.Description;
import test.BaseTest;
import config.ConfProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Objects;

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
        PopularBlock popularBlock = new PopularBlock();
        popularBlock
                .imgPopular(ConfProperties.getProperty("platform"))
                .boldNewsPopular(ConfProperties.getProperty("platform"))
                .colourHoverNewsPopular(ConfProperties.getProperty("platform"))
                .linkNewsPopular(ConfProperties.getProperty("platform"));
    }

    @Test
    @Description("Название блока Популярное, в блоке 10 новостей")
    public void checkPopularBlock() {
        PopularBlock popularBlock = new PopularBlock();
        popularBlock
                .headerTextPopularBlock(ConfProperties.getProperty("platform"))
                .countNewsPopular(ConfProperties.getProperty("platform"));
    }

    @Test
    @Description("У новостей оранжевый цвет, есть иконка комментирования, корректное количесвто комментариев")
    public void checkNewsPopular() {
        PopularBlock popularBlock = new PopularBlock();
        popularBlock
                .colourNewsNumberPopular(ConfProperties.getProperty("platform"))
                .commentNewsRegexPopular()
                .iconCommentNewsPopular();
    }
}
