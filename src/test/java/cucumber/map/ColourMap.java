package cucumber.map;

import data.pattern.colourPattern;
import java.util.HashMap;
import java.util.Map;

public class ColourMap {

    public static Map<String, String> colourMap = new HashMap<String, String>() {
        {
            put("Оранжевый", colourPattern.orangeColour());
        }
    };

}
