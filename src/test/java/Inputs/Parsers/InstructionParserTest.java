package Inputs.Parsers;

import Inputs.Instruction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {

    @Test
    @DisplayName("Returns null when provided an empty string")
    void parseInput() {

        // Arrange
        String emptyInput = "";

        // Act
        Instruction result = InstructionParser.parseInput(emptyInput);

        // Assert

        assertNull(result);

    }
}