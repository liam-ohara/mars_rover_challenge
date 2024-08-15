package Inputs.Parsers;

import Inputs.Instruction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

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

    @Test
    @DisplayName("Returns InputMisMatchException when passed input string that does not contain valid characters.")
    void testInstructionParserParseInput_WithInvalidCharacters() {

        // Arrange

        String invalidLetter = "a";
        String digit = "1";
        String punctuation = "!";



        // Act and Assert

        assertAll(

                () -> assertThrowsExactly(InputMismatchException.class, () -> InstructionParser.parseInput(invalidLetter)),
                () -> assertThrowsExactly(InputMismatchException.class, () -> InstructionParser.parseInput(digit)),
                () -> assertThrowsExactly(InputMismatchException.class, () -> InstructionParser.parseInput(punctuation)));
    }

    @Test
    @DisplayName("Returns valid List<Instruction> when provided with string of multiple instructions")
    void testInstructionParserParseInput_WithMultipleInputs() {
        // Arrange

        String instructions = "LMLMLMLMM";

        List<Instruction> listOfInstructions = new ArrayList<>();
        listOfInstructions.add(Instruction.L);
        listOfInstructions.add(Instruction.M);
        listOfInstructions.add(Instruction.L);
        listOfInstructions.add(Instruction.M);
        listOfInstructions.add(Instruction.L);
        listOfInstructions.add(Instruction.M);
        listOfInstructions.add(Instruction.L);
        listOfInstructions.add(Instruction.M);
        listOfInstructions.add(Instruction.M);


        // Act

        List<Instruction> result = InstructionParser.parseInstructions(instructions);

        // Assert

        assertEquals(listOfInstructions, result);

    }

}