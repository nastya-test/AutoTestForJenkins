package cucumber.map;

import data.pattern.linkPattern;
import java.util.HashMap;
import java.util.Map;

public class LinkMap {
    public static Map<String, String> linkMap = new HashMap<String, String>() {
        {
            put("Изоображение для иконки комментирования", linkPattern.iconComment);
            put("Ссылка на /video", linkPattern.linkTrailerBlock);
            put("Ссылка /lists/movies/recommendation", linkPattern.linkRecommendationsBlock);
            put("Ссылка /afisha/new/city", linkPattern.linkTicketsBlock);
        }
    };

}
