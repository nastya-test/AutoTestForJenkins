package test.mainPageTest;

import page.mainPage.blocks.Popover;
import io.qameta.allure.Description;
import test.BaseTest;
import config.ConfProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;

public class PopoverTest {

    @BeforeMethod
    public void openPage() {
        BaseTest.baseOpenPage(ConfProperties.getProperty("platform"),0);
    }
    @Test
    @Description("Базовые проверки для поповера")
    public void checkPopover() {
        page(Popover.class)
                .common();
//                .displayPopover()
//                .nameFilmPopover()
//                .yearFilmPopover()
//                .titleRolesPopover()
//                .actorPopover()
//                .titleDirectorsPopover()
//                .directorsPopover();
    }
}
