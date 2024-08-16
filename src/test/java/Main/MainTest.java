package Main;

import Main.Inputs.InstructionParser;
import Main.Inputs.PlateauCreationParser;
import Main.Inputs.RoverCreationParser;
import Main.Logic.Plateau;
import Main.Logic.Rover;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static Main.CompassDirection.*;

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

    @Test
    @DisplayName("Returns correct position of rover when provided with valid instructions")
    void testMain_IntegrationTestOfLogic() {
        // Arrange

        PlateauSize plateauSize = new PlateauSize(5, 5);
        Plateau plateau = new Plateau("Icaria Planum", plateauSize);


        Position position = new Position(1,2, CompassDirection.N);
        Rover rover = new Rover("Sojourner", position);

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
        Rover rover2 = new Rover("Opportunity", position2);

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

        Position expectedPositionRover = new Position(1, 3, N);
        Position expectedPositionRover2 = new Position(5, 1, E);


        // Act
        for (Instruction i : listOfInstructions) {
            rover.moveRover(i);
        }
        Position resultRover = rover.getRoverPosition();

        for (Instruction j: listOfInstructions2) {
            rover2.moveRover(j);
        }

        Position resultRover2 = rover2.getRoverPosition();

        // Assert

        assertAll (
                () -> assertEquals(expectedPositionRover, resultRover),
                () -> assertEquals(expectedPositionRover2, resultRover2));

    }
}