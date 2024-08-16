package Main.Inputs;

import Main.PlateauSize;

import java.util.InputMismatchException;

public class PlateauCreationParser {


    public static PlateauSize parseInput(String input) {
        int x = 0;
        int y = 0;

        if (input.isBlank()) {
            return null;
        }

        try {
            if (input.matches("^\\d*\\s\\d*")) {
                String[] inputArray = input.split("\\s");
                x = Integer.parseInt(inputArray[0]);
                y = Integer.parseInt(inputArray[1]);
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
