package test.mainPageTest;

import page.mainPage.blocks.Popover;
import io.qameta.allure.Description;
import test.BaseTest;
import config.ConfProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopoverTest {
//    @BeforeClass
//    public void authorized(){
//        BaseTest.baseOpenPage("web",0);
//        BaseTest.authorized();
//    }

    @BeforeMethod
    public void openPage() {
        BaseTest.baseOpenPage(ConfProperties.getProperty("platform"),0);
    }
    @Test
    @Description("Базовые проверки для поповера")
    public void checkPopover() {
        Popover popover = new Popover();
        popover
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
