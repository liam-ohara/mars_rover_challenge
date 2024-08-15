package Inputs;

import Inputs.Parsers.PlateauCreationParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class PlateauCreationParserTest {

    @Test
    @DisplayName("Returns PlateauSize instance with same attributes when given valid input string")
    void testPlateauCreationParserParseInput_WithValidInput() {
        // Arrange
        String plateauInput = "5 5";
        String plateauInput2 = "2 2";
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

    @Test
    @DisplayName("Returns null when provided an empty string")
    void testPlateauCreationParserParseInput_WithEmptyInput() {
        // Arrange
        String emptyInput = "";

        //Act
        PlateauSize result = PlateauCreationParser.parseInput(emptyInput);

        //Assert
        assertNull(result);

    }

    @Test
    @DisplayName("Returns InputMisMatchException when passed input without digits")
    void testPlateauCreationParserParseInput_WithNoDigitsInInput() {

        // Arrange
        String plateauInput = "a b";

        // Assert
        assertThrowsExactly(InputMismatchException.class, () -> PlateauCreationParser.parseInput(plateauInput));
    }

    @Test
    @DisplayName("Returns InputMisMatchException when passed input not separated by space")
    void testPlateauCreationParserParseInput_WithoutDelimiter() {

        // Arrange
        String withDelimiterInput = "22";

        // Assert
        assertThrowsExactly(InputMismatchException.class, () -> PlateauCreationParser.parseInput(withDelimiterInput));

    }

    @Test
    @DisplayName("Returns PlateauSize instance with same attributes when given input string for large plateau")
    void testPlateauCreationParserParseInput_ForLargePlateau() {

        // Arrange
        String plateauInput = "22 22";
        String plateauInput2 = "1000 1000";
        PlateauSize plateauSize = new PlateauSize(22, 22);
        PlateauSize plateauSize2 = new PlateauSize(1000, 1000);

        // Act
        PlateauSize result = PlateauCreationParser.parseInput(plateauInput);
        PlateauSize result2 = PlateauCreationParser.parseInput(plateauInput2);

        // Assert
        assertAll(
                () -> assertEquals(plateauSize, result),
                () -> assertEquals(plateauSize2, result2));

    }



}