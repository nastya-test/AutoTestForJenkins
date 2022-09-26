package page.cucumberStepDefinition;

import com.codeborne.selenide.SelenideElement;
import data.UserGenerator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.То;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginStep {
    //Кнопка "Вход"
    SelenideElement loginButton =  $(".styles_loginButton__LWZQp");

    //Поле логин
    SelenideElement loginField =  $("#passp-field-login");

    //Кнопка "Войти"
    SelenideElement signInButton =  $(".Button2_view_action");

    //Поле пароль
    SelenideElement passwordField =  $("#passp-field-passwd");

    //Аватар
    SelenideElement avatar =  $(".styles_root__42Fk8");

    //Поле с логином
    SelenideElement textLoginMainPage =  $(".styles_primaryTitleDefaultAccount__a0_6V");

    SelenideElement all  =  $(".styles_root__RPFB8");

    SelenideElement error  =  $(".Textinput-Hint");

    @Дано("переходит на страницу входа в аккаунт")
    public void переходит_на_страницу_входа_в_аккаунт() {
        loginButton.click();
    }

    @Дано("вводит существующий логин")
    public void вводит_существующий_логин() {
        loginField.click();
        loginField.setValue(UserGenerator.validUserLogin());
    }

    @Дано("нажимает продолжить")
    public void нажимает_продолжить() {
        signInButton.click();
    }

    @Дано("вводит пароль")
    public void вводит_пароль() {
        passwordField.click();
        passwordField.setValue(UserGenerator.validUserPassword());
    }

    @То("пользователь вошел в аккаунт")
    public void пользователь_вошел_в_аккаунт() {
        avatar.hover();
        assertThat(textLoginMainPage.getText()).as("Логин не совпал с введенным ранее").isEqualTo(UserGenerator.validUserLogin());
        all.hover();
    }

    @И("вводит в поле логин {string}")
    public void вводит_в_поле_логин(String arg0) {
        loginField.click();
        loginField.setValue(arg0);
    }

    @То("отобразилось сообщение об ошибке Такой логин не подойдет")
    public void отобразилось_сообщение_об_ошибке_такой_логин_не_подойдет() {
        assertThat(error.getText()).isEqualTo("Такой логин не подойдет");
    }

    @И("вводит пароль {string}")
    public void вводит_пароль(String password) {
        passwordField.click();
        passwordField.setValue(password);
    }

    @То("отобразилось сообщение об ошибке Неверный пароль")
    public void отобразилось_сообщение_об_ошибке_неверный_пароль() {
        assertThat(error.getText()).isEqualTo("Неверный пароль");
    }


    @Дано("передача данных, перечисленных через запятую, в ArrayList (.*)")
    public void передачаДанныхПеречисленныхЧерезЗапятуюВArrayList(List<String> arg) {
        System.out.println(arg);
    }

//    @И("передача данных, перечисленных через разделитель, в ArrayList, аннотация Delimiter (.*)")
//    public void передачаДанныхПеречисленныхЧерезРазделительВArrayListАннотацияDelimiter(@Delimiter(" и ") List<String> arg) {
//    }

    @И("передача данных, записанных в виде таблицы с одной колонкой")
    public void передачаДанныхЗаписанныхВВидеТаблицыСОднойКолонкой(List<String> arg) {
        System.out.println(arg);
    }

    @И("передача данных, записанных в виде таблицы с двумя колонками")
    public void передачаДанныхЗаписанныхВВидеТаблицыСДвумяКолонками(Map<String, Boolean> arg) {
        System.out.println(arg);
    }

    @И("передача данных, используя DataTable")
    public void передачаДанныхИспользуяDataTable(DataTable arg) {
        List<Map<String, String>> table = arg.asMaps(String.class, String.class);
        System.out.println(table.get(0).get("Название"));
        System.out.println(table.get(1).get("Название"));
        System.out.println(table.get(2).get("Название"));
    }

    @И("передача данных, используя Class")
    public void передачаДанныхИспользуяClass() {
    }

    @И("вводит в поле логин Тест Регулярки ([A-Za-z0-9-]+)")
    public void вводитВПолеЛогинТестРегулярки() {

    }

    @И("передача многострочных аргументов")
    public void передачаМногострочныхАргументов() {
        
    }

    @И("передача Data")
    public void передачаData() {
    }
}
