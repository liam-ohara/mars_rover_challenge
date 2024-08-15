package Inputs.Parsers;

import Inputs.Instruction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {

    @Test
    @DisplayName("Returns null when provided an empty string")
    void testInstructionParserParseInput_WithEmptyInput() {

        // Arrange
        String emptyInput = "";

        // Act
        Instruction result = InstructionParser.parseInput(emptyInput);

        // Assert

        assertNull(result);

    }

    @Test
    @DisplayName("Returns valid instruction when provided with single valid instructions")
    void testInstructionParserParseInput_WithValidInputs() {
        // Arrange

        String left = "L";
        String right = "R";
        String move = "M";

        Instruction turnLeft = Instruction.L;
        Instruction turnRight = Instruction.R;
        Instruction makeMove = Instruction.M;

        // Act

        Instruction result = InstructionParser.parseInput(left);
        Instruction result2 = InstructionParser.parseInput(right);
        Instruction result3 = InstructionParser.parseInput(move);

        // Assert

        assertAll(
                () -> assertEquals(turnLeft, result),
                () -> assertEquals(turnRight, result2),
                () -> assertEquals(makeMove, result3));

    }

    @Test
    @DisplayName("Returns valid instruction when provided with single lowercase instructions")
    void testInstructionParserParseInput_WithLowercaseInputs() {
        // Arrange

        String left = "l";
        String right = "r";
        String move = "m";

        Instruction turnLeft = Instruction.L;
        Instruction turnRight = Instruction.R;
        Instruction makeMove = Instruction.M;

        // Act

        Instruction result = InstructionParser.parseInput(left);
        Instruction result2 = InstructionParser.parseInput(right);
        Instruction result3 = InstructionParser.parseInput(move);

        // Assert

        assertAll(
                () -> assertEquals(turnLeft, result),
                () -> assertEquals(turnRight, result2),
                () -> assertEquals(makeMove, result3));

    }

}