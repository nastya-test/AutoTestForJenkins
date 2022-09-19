package test.mainPageTest;

import page.mainPage.blocks.Popover;
import io.qameta.allure.Description;
import test.BaseTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;

public class PopoverTest extends BaseTest{

    @Test
    @Description("Базовые проверки для поповера")
    public void checkPopover() {
        page(Popover.class)
                .common();
    }
}
