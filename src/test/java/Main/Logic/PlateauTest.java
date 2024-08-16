package Main.Logic;

import Main.PlateauSize;
import Main.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static Main.CompassDirection.*;
import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    @DisplayName("Returns null when there are no rovers added to listOfRovers in Plateau class.")
    void testGetListOfRovers_WithNoRovers () {

        //Act
        List<Rover> result = Plateau.getListOfRovers();

        //Assert
        assertNull(result);
    }


    @Test
    @DisplayName("Returns list containing single rover when passed a single rover.")
    void testAddRover_WithSingleRover() {
        //Arrange
        PlateauSize plateauSize = new PlateauSize(10, 10);
        Plateau plateau = new Plateau("Icaria Planum", plateauSize);
        Position roverLandingSite = new Position(0, 0, N);
        Rover rover = new Rover("Pathfinder", roverLandingSite);
        List<Rover> listOfRovers = new ArrayList<>();
        listOfRovers.add(rover);

        //Act
        plateau.addRover(rover);
        List<Rover> result = Plateau.getListOfRovers();

        //Assert
        assertEquals(listOfRovers, result);

    }

    @Test
    @DisplayName("Returns list containing multiple rovers when passed multiple rovers.")
    void testAddRover_WithMultipleRovers() {
        //Arrange
        PlateauSize plateauSize = new PlateauSize(10, 10);
        Plateau plateau = new Plateau("Icaria Planum", plateauSize);
        Position roverLandingSite = new Position(0, 0, N);
        Position roverLandingSite2 = new Position(5, 5, S);
        Position roverLandingSite3 = new Position(10, 10, E);
        Rover rover = new Rover("Pathfinder", roverLandingSite);
        Rover rover2 = new Rover("Opportunity", roverLandingSite);
        Rover rover3 = new Rover("Spirit", roverLandingSite);
        List<Rover> listOfRovers = new ArrayList<>();
        listOfRovers.add(rover);
        listOfRovers.add(rover2);
        listOfRovers.add(rover3);

        //Act;
        plateau.addRover(rover);
        plateau.addRover(rover2);
        plateau.addRover(rover3);
        List<Rover> result = Plateau.getListOfRovers();

        //Assert
        assertEquals(listOfRovers, result);

    }
}