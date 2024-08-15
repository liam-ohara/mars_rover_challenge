package Inputs.Parsers;

import Inputs.CompassDirection;
import Inputs.Instruction;
import Inputs.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverCreationParserTest {

    @Test
    @DisplayName("Returns null when provided an empty string")
    void testRoverCreationParserParseInput_WithEmptyInput() {

        // Arrange
        String emptyInput = "";

        // Act
        Position result = RoverCreationParser.parseInput(emptyInput);

        // Assert

        assertNull(result);
    }

    @Test
    @DisplayName("Returns Position when provided with valid input string")
    void testRoverCreationParserParseInput_WithValidInput() {

        // Arrange
        String input = "1 2 N";
        Position startPosition = new Position(1,2, CompassDirection.N);

        // Act
        Position result = RoverCreationParser.parseInput(input);

        // Assert
        assertEquals(startPosition, result);
    }
}