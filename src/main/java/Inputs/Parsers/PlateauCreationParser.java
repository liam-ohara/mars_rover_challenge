package Inputs.Parsers;

import Inputs.PlateauSize;

public class PlateauCreationParser implements InputParser {

    private PlateauSize plateauSize;

    private PlateauCreationParser(PlateauSize plateauSize) {
        this.plateauSize = plateauSize;
    }

    public PlateauSize getPlateauSize() {
        return this.plateauSize;
    }

    @Override
    public void parseInput(String input) {
        int x = 0;
        int y = 0;

        x = Character.getNumericValue(input.charAt(0));
        y = Character.getNumericValue(input.charAt(input.length() -1));

        this.plateauSize = new PlateauSize(x, y);

    }
}
