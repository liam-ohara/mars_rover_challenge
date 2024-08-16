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
    @DisplayName("Adds single rover to a List<Rover> on plateau.")
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
    @DisplayName("Adds multiple rovers to a List<Rover> on plateau.")
    void testAddRover_WithMultipleRovers() {
        //Arrange
        PlateauSize plateauSize = new PlateauSize(10, 10);

        Plateau plateau = new Plateau("Icaria Planum", plateauSize);

        Position roverLandingSite = new Position(0, 0, N);
        Position roverLandingSite2 = new Position(5, 5, S);
        Position roverLandingSite3 = new Position(10, 10, E);

        Rover rover = new Rover("Sojourner", roverLandingSite);
        Rover rover2 = new Rover("Opportunity", roverLandingSite2);
        Rover rover3 = new Rover("Spirit", roverLandingSite3);

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
    @Test
    @DisplayName("Adds rovers to separate instances of List<Rovers> for separate plateaux")
    void testAddRover_WithMultipleRoversAndPlateaux() {
        // Arrange
        PlateauSize plateauSize = new PlateauSize(10, 10);
        PlateauSize plateauSize2 = new PlateauSize(12, 12);

        Plateau plateau = new Plateau("Icaria Planum", plateauSize);
        Plateau plateau2 = new Plateau("Lucus Planum", plateauSize2);

        Position roverLandingSite = new Position(0, 0, N);
        Position roverLandingSite2 = new Position(5, 5, S);
        Position roverLandingSite3 = new Position(10, 10, E);

        Rover rover = new Rover("Sojourner", roverLandingSite);
        Rover rover2 = new Rover("Opportunity", roverLandingSite2);
        Rover rover3 = new Rover("Spirit", roverLandingSite3);
        Rover rover4 = new Rover("Curiosity", roverLandingSite);
        Rover rover5 = new Rover("Perseverance", roverLandingSite2);

        List<Rover> listOfRovers = new ArrayList<>();
        listOfRovers.add(rover);
        listOfRovers.add(rover2);
        listOfRovers.add(rover3);

        List<Rover> listOfRovers2 = new ArrayList<>();
        listOfRovers2.add(rover4);
        listOfRovers2.add(rover5);


        //Act
        plateau.addRover(rover);
        plateau.addRover(rover2);
        plateau.addRover(rover3);
        plateau2.addRover(rover4);
        plateau2.addRover(rover5);
        List<Rover> result = plateau.getListOfRovers();
        List<Rover> result2 = plateau2.getListOfRovers();

        //Assert

        assertAll(
                () -> assertEquals(listOfRovers, result),
                () -> assertEquals(listOfRovers2, result2));

    }

}