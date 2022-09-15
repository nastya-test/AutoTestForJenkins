package data;

public class regexPattern {

    public static String regexName(){
        return "[А-ЯЁA-Z0-9][A-ZA-ЯЁa-zа-яё0-9,!?№:\\.\\-\\—\\s\\(\\)]*";
    }

    public static String regexRating(){
        return "(^[0-9]{1}\\.[0-9]{1}$)|(^\\–$)|(^[0-9]{1,2})\\%{1}$";
    }

    public static String regexYearAndGenre() { return "([1][9][0-9][0-9]|[2][0][0-2][0-9]|[1][8][9][5-9]){1}(\\,)\\s([а-я]{4,})";}

    public static String regexFilmOrSeriesLink() {return "(https:\\/\\/www\\.kinopoisk\\.ru\\/)((film\\/)|(series\\/))([0-9]{1,})\\/";}

    public static String regexLabelTickets() {return "(https:\\/\\/www\\.kinopoisk\\.ru\\/afisha\\/new\\/film)\\/([0-9]{1,})\\/";}

    public static String commentNewsPopular() {return "[0-9]{1,}";}

    public static String filmWithoutRoles() {return "^(МУЛЬТ)[A-ZA-ЯЁa-zа-яё0-9,!?№:\\.\\-\\—\\s\\(\\)]*";}

}
