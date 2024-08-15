package Inputs.Parsers;

import Inputs.CompassDirection;
import Inputs.Position;

import java.util.InputMismatchException;

public class RoverCreationParser {

    public static Position parseInput(String input) {
        int x;
        int y;
        CompassDirection facing = null;
        Position roverPosition;


        if (input.isBlank()) {
            return null;
        }


        try {

            if (input.matches("^\\d\\s\\d\\s[NESW]")) {
                String[] inputArray = input.split("\\s");
                x = Integer.parseInt(inputArray[0]);
                y = Integer.parseInt(inputArray[1]);
                switch (inputArray[2]) {
                    case "N":
                        facing = CompassDirection.N;
                        break;
                    case "E":
                        facing = CompassDirection.E;
                        break;
                    case "S":
                        facing = CompassDirection.S;
                        break;
                    case "W":
                        facing = CompassDirection.W;
                }
            } else {
                throw new InputMismatchException();

            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Rover starting position must contain xy coordinates and compass direction each separated by a space.");
        }


        roverPosition = new Position(x, y, facing);
        return roverPosition;
    }
}
