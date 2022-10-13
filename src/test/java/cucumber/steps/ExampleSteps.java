package cucumber.steps;

import cucumber.pageobjects.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.page;

public class ExampleSteps {

    @И("передача данных, записанных в виде таблицы с одной колонкой")
    public void передачаДанныхЗаписанныхВВидеТаблицыСОднойКолонкой(List<String> arg) {
        System.out.println(arg);
    }


    @И("передача данных, используя DataTable")
    public void передачаДанныхИспользуяDataTable(DataTable arg) {
        List<Map<String, String>> table = arg.asMaps(String.class, String.class);
        List<List<String>> table2 = arg.asLists(String.class);
        System.out.println(table.get(0).get("Название"));
        System.out.println(table2.get(0).get(0));
        System.out.println(table.get(0).get("Тип"));
        System.out.println(table.get(0).get("Значение"));
        System.out.println(table.get(1).get("Название"));
        System.out.println(table.get(2).get("Название"));
    }

}
