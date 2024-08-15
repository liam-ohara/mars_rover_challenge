package Inputs;

public class PlateauCreationParser implements InputParser {

    private PlateauSize plateauSize;

    public PlateauCreationParser(PlateauSize plateauSize) {
        this.plateauSize = plateauSize;
    }

    public PlateauSize getPlateauSize() {
        return plateauSize;
    }

    @Override
    public void parseInput(String input) {

    }
}
