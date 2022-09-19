package test.mainPageTest;

import page.mainPage.blocks.PopularBlock;
import page.mainPage.blocks.RecommendationsBlock;
import io.qameta.allure.Description;
import test.BaseTest;
import config.ConfProperties;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;

public class RecommendationsTest {

    @BeforeClass
    public void authorized(){
        BaseTest.baseOpenPage((ConfProperties.getProperty("platform")),0);
        BaseTest.authorized(ConfProperties.getProperty("platform"));
    }

    @BeforeMethod
    public void openPage() {
        BaseTest.baseOpenPage(ConfProperties.getProperty("platform"),7);
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
