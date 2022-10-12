package cucumber.converter;

import data.colourPattern;

public class ColourConverter {
    public static String getColourByName(String colour){
        switch (colour){
            case "Оранжевый":
                return colourPattern.orangeColour();
            case "Чёрный":
                return colourPattern.blackColour();
        }
        return null;
    }
}
