package Inputs;

import org.junit.jupiter.api.Test;

class PlateauCreationParserTest {

    @Test
    void testParseInput() {
        // Arrange
        String plateauInput = "5 5";
        PlateauSize plateauSize = new PlateauSize(5, 5);
        PlateauCreationParser plateauCreationParser = PlateauCreationParser.parseInput();


        // Act
        PlateauCreationParser.parseInput(plateauInput);
        PlateauSize result = PlateauCreationParser.getPlateauSize();

        // Assert



    }
}