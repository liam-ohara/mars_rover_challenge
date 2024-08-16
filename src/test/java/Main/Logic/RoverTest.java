package Main.Logic;

import Main.Instruction;
import Main.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Main.CompassDirection.*;

import static Main.Instruction.*;
import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    @DisplayName("Rover position is unchanged when passed an empty instruction")
    void testMoveRover_WithEmptyInstruction() {
        //Arrange
        Position roverLandingSite = new Position(0, 0, N);
        Rover rover = new Rover("Pathfinder", roverLandingSite);
        Instruction instruction = null;

        //Act
        rover.moveRover(instruction);
        Position result = rover.getRoverPosition();

        //Assert
        assertEquals(roverLandingSite, result);

    }

    @Test
    @DisplayName("Rover position is updated correctly when passed a valid instructions")
    void testMoveRover_WithValidInstructions() {
        //Arrange
        Position roverLandingSite = new Position(0, 0, N);
        Rover rover = new Rover("Pathfinder", roverLandingSite);
        Instruction instruction = M;
        Instruction instruction2 = R;
        Instruction instruction3 = M;
        Instruction instruction4 = L;
        Position newPosition = new Position(0, 1, N);
        Position newPosition2 = new Position(0, 1, E);
        Position newPosition3 = new Position(1, 1, E);
        Position newPosition4 = new Position(1, 1, N);



        //Act
        rover.moveRover(instruction);
        Position result = rover.getRoverPosition();
        rover.moveRover(instruction2);
        Position result2 = rover.getRoverPosition();
        rover.moveRover(instruction3);
        Position result3 = rover.getRoverPosition();
        rover.moveRover(instruction4);
        Position result4 = rover.getRoverPosition();

        //Assert

        assertAll(
                () -> assertEquals(newPosition, result),
                () -> assertEquals(newPosition2, result2),
                () -> assertEquals(newPosition3, result3),
                () -> assertEquals(newPosition4, result4));

    }
}