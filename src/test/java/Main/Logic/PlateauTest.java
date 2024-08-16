package Main.Logic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    @DisplayName("Returns null when there are no rovers added to listOfRovers in Plateau class.")
    void testGetListOfRovers () {

        //Act
        List<Rover> result = Plateau.getListOfRovers();

        //Assert
        assertNull(result);
    }


    @Test
    void addRover() {
    }
}