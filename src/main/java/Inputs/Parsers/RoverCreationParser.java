package Inputs.Parsers;

import Inputs.CompassDirection;
import Inputs.Position;

public class RoverCreationParser {

    public static Position parseInput(String input) {
        int x = 0;
        int y = 0;
        CompassDirection facing = null;


        if (input.isBlank()) {
            return null;
        }

        //Regex= ^\d\s\d[NESW]
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

        Position roverPosition = new Position(x, y, facing);

        return roverPosition;


    }
}
