package Inputs.Parsers;

import Inputs.CompassDirection;
import Inputs.Instruction;
import Inputs.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

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

    @Test
    @DisplayName("Returns InputMisMatchException when passed input in invalid form")
    void testRoverCreationParserParseInput_WithInvalidInputs() {

    // Arrange
    String invalidInput = "12N";
    String invalidInput1 = "1N";
    String invalidInput2 = "1 2N";
    String invalidInput3 = "12 N";
    String invalidInput4 = "121";
    String invalidInput5 = "NNN";


    // Act and Assert

    assertAll(
                () -> assertThrowsExactly(InputMismatchException.class, () -> RoverCreationParser.parseInput(invalidInput)),
            () -> assertThrowsExactly(InputMismatchException.class, () -> RoverCreationParser.parseInput(invalidInput1)),
            () -> assertThrowsExactly(InputMismatchException.class, () -> RoverCreationParser.parseInput(invalidInput2)),
            () -> assertThrowsExactly(InputMismatchException.class, () -> RoverCreationParser.parseInput(invalidInput3)),
            () -> assertThrowsExactly(InputMismatchException.class, () -> RoverCreationParser.parseInput(invalidInput4)),
            () -> assertThrowsExactly(InputMismatchException.class, () -> RoverCreationParser.parseInput(invalidInput5)));
}
}