package Main;

import Main.Inputs.InstructionParser;
import Main.Inputs.PlateauCreationParser;
import Main.Inputs.RoverCreationParser;
import Main.Logic.Plateau;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("Returns valid objects when passed valid inputs")
    void testMain_IntegationTestOfInputs() {

        //Arrange
        List<String> input = new ArrayList<>();
        input.add("5 5");
        input.add("1 2 N");
        input.add("LMLMLMLMM");
        input.add("3 3 E");
        input.add("MMRMMRMRRM");

        PlateauSize plateauSize = new PlateauSize(5, 5);

        Position position = new Position(1,2, CompassDirection.N);

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

        Position position2 = new Position(3,3, CompassDirection.E);

        List<Instruction> listOfInstructions2 = new ArrayList<>();
        listOfInstructions2.add(Instruction.M);
        listOfInstructions2.add(Instruction.M);
        listOfInstructions2.add(Instruction.R);
        listOfInstructions2.add(Instruction.M);
        listOfInstructions2.add(Instruction.M);
        listOfInstructions2.add(Instruction.R);
        listOfInstructions2.add(Instruction.M);
        listOfInstructions2.add(Instruction.R);
        listOfInstructions2.add(Instruction.R);
        listOfInstructions2.add(Instruction.M);


        //Act
        PlateauSize plateauSizeResult = PlateauCreationParser.parseInput(input.get(0));
        Position positionResult = RoverCreationParser.parseInput(input.get(1));
        List<Instruction> instructionResult = InstructionParser.parseInstructions(input.get(2));
        Position positionResult2 = RoverCreationParser.parseInput(input.get(3));
        List<Instruction> instructionResult2 = InstructionParser.parseInstructions(input.get(4));


        //Assert
        assertAll(
                () -> assertEquals(plateauSize, plateauSizeResult),
                () -> assertEquals(position, positionResult),
                () -> assertEquals(listOfInstructions, instructionResult),
                () -> assertEquals(position2, positionResult2),
                () -> assertEquals(listOfInstructions2, instructionResult2));

    }
}