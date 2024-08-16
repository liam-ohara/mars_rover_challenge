package Main.Logic;

import Main.PlateauSize;
import Main.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static Main.CompassDirection.N;
import static Main.CompassDirection.S;
import static org.junit.jupiter.api.Assertions.*;

class MissionControlTest {

    @Test
    @DisplayName("Returns true when passed empty plateau")
    void testIsPositionEmpty_WithPlateauNoRovers() {
        // Arrange
        PlateauSize plateauSize = new PlateauSize(10, 10);
        Plateau plateau = new Plateau("Icaria Planum", plateauSize);
        int x = 0;
        int y = 0;

        // Act
        boolean result = MissionControl.isPositionEmpty(plateau, x, y);

        // Assert
        assertTrue(result);

    }

    @Test
    @DisplayName("Returns true when passed coordinates in plateau not occupied by a rover")
    void testIsPositionEmpty_WithPlateauRoversUnOccupiedCoordinates() {

        // Arrange
        PlateauSize plateauSize = new PlateauSize(10, 10);
        Plateau plateau = new Plateau("Icaria Planum", plateauSize);
        int xCoordinateToCheck = 1;
        int yCoordinateToCheck = 1;

        //Add rovers
        Position roverLandingSite = new Position(0, 0, N);
        Position roverLandingSite2 = new Position(5, 5, S);

        Rover rover = new Rover("Sojourner", roverLandingSite);
        Rover rover2 = new Rover("Opportunity", roverLandingSite2);


        plateau.addRover(rover);
        plateau.addRover(rover2);

        // Act
        boolean result = MissionControl.isPositionEmpty(plateau, xCoordinateToCheck, yCoordinateToCheck);

        // Assert
        assertTrue(result);

    }

    @Test
    @DisplayName("Returns false when passed coordinates in plateau occupied by a rover")
    void testIsPositionEmpty_WithPlateauRoversOccupiedCoordinates() {

        // Arrange
        PlateauSize plateauSize = new PlateauSize(10, 10);
        Plateau plateau = new Plateau("Icaria Planum", plateauSize);

        int xCoordinateToCheck = 1;
        int yCoordinateToCheck = 1;

        Position roverLandingSite = new Position(1, 1, N);
        Position roverLandingSite2 = new Position(5, 5, S);

        Rover rover = new Rover("Sojourner", roverLandingSite);
        Rover rover2 = new Rover("Opportunity", roverLandingSite2);


        plateau.addRover(rover);
        plateau.addRover(rover2);

        // Act
        boolean result = MissionControl.isPositionEmpty(plateau, xCoordinateToCheck, yCoordinateToCheck);

        // Assert
        assertFalse(result);

    }

    @Test
    @DisplayName("Return false when provided with coordinates within size of plateau.")
    void testAreCoordinatesOutOfBounds_WithCoordinatesWithinPlateauSize() {
        // Arrange

        PlateauSize plateauSize = new PlateauSize(10, 10);
        Plateau plateau = new Plateau("Icaria Planum", plateauSize);

        int xCoordinateToCheck = 1;
        int yCoordinateToCheck = 1;

        // Act
        boolean result = MissionControl.areCoordinatesOutOfBounds(plateau, xCoordinateToCheck, yCoordinateToCheck);

        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Return true when provided with coordinates outside size of plateau.")
    void testAreCoordinatesOutOfBounds_WithCoordinatesOutsidePlateauSize() {
        // Arrange

        PlateauSize plateauSize = new PlateauSize(10, 10);
        Plateau plateau = new Plateau("Icaria Planum", plateauSize);

        int xCoordinateToCheck = 10;
        int yCoordinateToCheck = 10;

        // Act
        boolean result = MissionControl.areCoordinatesOutOfBounds(plateau, xCoordinateToCheck, yCoordinateToCheck);

        // Assert
        assertTrue(result);
    }
}