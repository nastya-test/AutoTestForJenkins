package cucumber.map;

import data.pattern.regexPattern;
import java.util.HashMap;
import java.util.Map;

public class RegexMap {
    public static Map<String, String> regexMap = new HashMap<String, String>() {
        {
            put("Регулярное выражение для проверки названия фильма", regexPattern.regexName());
            put("Регулярное выражение для проверки жанра и года фильма", regexPattern.regexYearAndGenre());
            put("Регулярное выражение для проверки ссылки фильма", regexPattern.regexFilmOrSeriesLink());
            put("Регулярное выражение для проверки рейтинга фильма", regexPattern.regexRating());
            put("Регулярное выражение для количества комментариев",regexPattern.commentNewsPopular());
        }
    };

}
