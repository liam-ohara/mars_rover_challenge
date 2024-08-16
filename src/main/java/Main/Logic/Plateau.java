package Main.Logic;

import Main.PlateauSize;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private String plateauName;
    private PlateauSize plateauSize;
    private List<Rover> listOfRovers;

    public Plateau (String plateauName, PlateauSize plateauSize) {
        this.plateauName = plateauName;
        this.plateauSize = plateauSize;
    }

    public String getPlateauName () {
        return this.plateauName;
    }

    public PlateauSize getPlateauSize () {
        return this.plateauSize;
    }

    public void addRover (Rover rover) {
        if (this.listOfRovers == null) {
            this.listOfRovers = new ArrayList<>();
            this.listOfRovers.add(rover);
        } else {
            this.listOfRovers.add(rover);
        }
    }

    public List<Rover> getListOfRovers() {
        if (this.listOfRovers == null) {
            return null;
        } else {
            return this.listOfRovers;
        }
    }
}
