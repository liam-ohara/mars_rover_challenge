package Main.Logic;

import Main.Instruction;
import Main.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Main.CompassDirection.*;

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
}