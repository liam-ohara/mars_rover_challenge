package Main.Logic;

import Main.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MissionControl {

    public static boolean isPositionEmpty(Plateau plateauName, int x, int y) {

        if (plateauName.getListOfRovers() == null) {
            return true;
        } else {
            Map<Integer, Integer> occupiedCoordinates = new HashMap<>();
            List<Rover> listofRovers = new ArrayList<>();
            List<Position> occupiedPositions = new ArrayList<>();
            listofRovers = plateauName.getListOfRovers();

            for (Rover j : listofRovers) {
                occupiedPositions.add(j.getRoverPosition());
            }

            for (Position k : occupiedPositions) {
                occupiedCoordinates.put(k.x(), k.y());
            }

            if (!occupiedCoordinates.containsKey(x)) {
                return true;
            } else {
                if (occupiedCoordinates.get(x) != y) {
                    return true;
                }
            }
        }
        return false;
    }
}
