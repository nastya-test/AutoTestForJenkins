package org.example.Test.MainPageTest;

import PageObject.MainPage.Blocks.RecommendationsBlock;
import io.qameta.allure.Description;
import org.example.BaseTest;
import org.example.ConfProperties;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        RecommendationsBlock recommendationsBlock = new RecommendationsBlock();
        recommendationsBlock
                .imgRecommend()
                .assertNameRecommendRegex()
                .assertYearAndGenreRecommendRegex()
                .assertHrefRecommendRegex()
                .assertRatingRecommendRegex();
    }

    @Test
    @Description("Название блока и ссылка")
    public void checkHeaderRecommendBlock() {
        RecommendationsBlock recommendationsBlock = new RecommendationsBlock();
        recommendationsBlock
                .nameRecommendationsBlock()
                .hrefRecommendationsBlock();
    }

    @Test
    @Description("Скролл")
    public void checkScroll() {
        RecommendationsBlock recommendationsBlock = new RecommendationsBlock();
        recommendationsBlock
                .scrollRecommend(ConfProperties.getProperty("platform"));
    }
}
