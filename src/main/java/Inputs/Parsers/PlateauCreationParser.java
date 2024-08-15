package Inputs.Parsers;

import Inputs.PlateauSize;

import java.util.InputMismatchException;

public class PlateauCreationParser {


    public static PlateauSize parseInput(String input) {
        int x = 0;
        int y = 0;

        if (input.isBlank()) {
            return null;
        }

        try {
            if (input.matches("^\\d\\s\\d")) {
                x = Character.getNumericValue(input.charAt(0));
                y = Character.getNumericValue(input.charAt(input.length() - 1));
            } else {
                throw new InputMismatchException();
            }
        }

        catch (InputMismatchException e) {
            throw new InputMismatchException ("Plateau size must contain xy coordinates separated by a space.");
        }

        return new PlateauSize(x, y);

    }
}
