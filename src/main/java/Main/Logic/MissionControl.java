package Main.Logic;

public class MissionControl {

    public static boolean isPositionEmpty (Plateau plateauName, int x, int y) {

        if (plateauName.getListOfRovers() == null) {
            return true;
        }
        return false;
    }

}
