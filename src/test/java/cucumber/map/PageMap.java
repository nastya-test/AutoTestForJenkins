package cucumber.map;

import cucumber.pageobjects.*;
import cucumber.pageobjects.mainPage.FilmTicketsPage;
import cucumber.pageobjects.mainPage.MainPage;
import cucumber.pageobjects.mainPage.PopularPage;

import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.Selenide.page;

public class PageMap {

    public static Map<Boolean, AbstractPage> activePageMap = new HashMap<Boolean, AbstractPage>() {
        {
            put(true, page(MainPage.class));
        }
    };

    public static void setPopularPages(AbstractPage page) {
        activePageMap.clear();
        activePageMap.put(true, page);
    }

    public static Map<String, AbstractPage> savePageMap = new HashMap<String, AbstractPage>() {
        {
            put("Блок Популярное", page(PopularPage.class));
            put("Блок Билеты в кино", page(FilmTicketsPage.class));
        }
    };

}
