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
        PlateauSize plateauSize = new PlateauSize(5, 5);

        // Act
        PlateauSize result = PlateauCreationParser.parseInput(plateauInput);

        // Assert
        assertEquals(plateauSize, result);



    }
}