package cucumber.runners.cucmber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        //tags = "@success", //Символ ~ исключает тест из списка запускаемых тестов
        features = {"src/test/java/features/LoginTestCase.feature"}, //где хранятся .features
        glue = {"page.cucumberStepDefinition"}, //где хранятся steps и hooks
        plugin = {},
        snippets = CucumberOptions.SnippetType.CAMELCASE) //snippets – указывает в каком формате фреймворк будет предлагать шаблон для нереализованных шагов. Доступны значения: SnippetType.CAMELCASE, SnippetType.UNDERSCORE.
        //name – фильтрует запускаемые тесты по названиям удовлетворяющим регулярному выражению.
        //dryRun – если true, то сразу после запуска теста фреймворк проверяет, все ли шаги теста разработаны, если нет, то выдает предупреждение. При false предупреждение будет выдаваться по достижении неразработанного шага. По умолчанию false.
        //strict – если true, то при встрече неразработанного шага тест остановится с ошибкой. False — неразработанные шаги пропускаются. По умолчанию false.
public class LoginRunnerTest extends AbstractTestNGCucumberTests {
}
