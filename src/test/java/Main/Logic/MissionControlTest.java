package Main.Logic;

import Main.PlateauSize;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class MissionControlTest {

    @Test
    @DisplayName("Returns false when passed empty plateau")
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
}