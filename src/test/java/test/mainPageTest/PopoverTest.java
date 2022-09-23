package test.mainPageTest;

import org.testng.annotations.BeforeMethod;
import page.mainPage.blocks.Popover;
import io.qameta.allure.Description;
import test.BaseTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.page;

public class PopoverTest extends BaseTest{

    @BeforeMethod
    public void scrolling(){
        page(Popover .class).scrollToFilmTicketsBlock();
    }

    @Test
    @Description("Базовые проверки для поповера")
    public void checkPopover() {
        page(Popover.class)
                .common();
    }
}
