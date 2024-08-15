package Inputs;

import Inputs.Parsers.PlateauCreationParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlateauCreationParserTest {

    @Test
    @DisplayName("Returns PlateauSize instance with same attributes when given valid input string")
    void testPlateauCreationParserParseInput_WithValidInput() {
        // Arrange
        String plateauInput = "5 5";
        String plateauInput2 = "22";
        PlateauSize plateauSize = new PlateauSize(5, 5);
        PlateauSize plateauSize2 = new PlateauSize(2, 2);

        // Act
        PlateauSize result = PlateauCreationParser.parseInput(plateauInput);
        PlateauSize result2 = PlateauCreationParser.parseInput(plateauInput2);

        // Assert
        assertAll(
                () -> assertEquals(plateauSize, result),
                () -> assertEquals(plateauSize2, result2));

    }


}