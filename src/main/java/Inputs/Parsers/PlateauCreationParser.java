package Inputs.Parsers;

import Inputs.PlateauSize;

public class PlateauCreationParser {


    public static PlateauSize parseInput(String input) {
        int x = 0;
        int y = 0;

        x = Character.getNumericValue(input.charAt(0));
        y = Character.getNumericValue(input.charAt(input.length() -1));

        return new PlateauSize(x, y);

    }
}
