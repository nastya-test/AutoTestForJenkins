package cucumber.converter;

import data.constants;

public class ConstantsConverter {
    public  static String getConstantsByName(String name){
        switch (name){
            case "Изоображение для иконки комментирования":
                return constants.iconComment;
            case "Ссылка на /video":
                return constants.linkTrailerBlock;
            case "Ссылка /lists/movies/recommendation":
                return constants.linkRecommendationsBlock;
            case "Ссылка /afisha/new/city":
                return constants.linkTicketsBlock;
        }
        return null;
    }
}
