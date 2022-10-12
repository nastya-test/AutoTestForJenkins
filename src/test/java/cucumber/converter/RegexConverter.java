package cucumber.converter;

import data.regexPattern;

public class RegexConverter {
    public static String getRegexByName(String name){
        switch (name){
            case "Регулярное выражение для проверки названия фильма":
                return regexPattern.regexName();
            case "Регулярное выражение для проверки жанра и года фильма":
                return regexPattern.regexYearAndGenre();
            case "Регулярное выражение для проверки ссылки фильма":
                return regexPattern.regexFilmOrSeriesLink();
            case "Регулярное выражение для проверки рейтинга фильма":
                return regexPattern.regexRating();
            case "Регулярное выражение для количества комментариев":
                return regexPattern.commentNewsPopular();
        }
        return null;
    }
}
