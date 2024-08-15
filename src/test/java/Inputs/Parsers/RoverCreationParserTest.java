package Inputs.Parsers;

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
}