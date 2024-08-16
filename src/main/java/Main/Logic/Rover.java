package Main.Logic;

import Main.Position;

public class Rover {
    private String roverName;
    private Position roverPosition;

    public Rover(String roverName, Position roverPosition) {
        this.roverName = roverName;
        this.roverPosition = roverPosition;
    }

    public String getRoverName () {
        return this.roverName;
    }

    public Position getRoverPosition () {
        return this.roverPosition;
    }

    public void setRoverPosition (Position newRoverPosition) {
        this.roverPosition = newRoverPosition;
    }



}
