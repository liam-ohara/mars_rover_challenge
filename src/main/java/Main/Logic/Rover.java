package Main.Logic;

import Main.CompassDirection;
import Main.Instruction;
import Main.Position;
import static Main.CompassDirection.*;

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

    public void moveRover (Instruction instruction) {
        if (instruction != null) {
            switch (instruction) {
                case L:
                    Position currentPosition = this.roverPosition;
                    int x = currentPosition.x();
                    int y = currentPosition.y();
                    CompassDirection facing = currentPosition.facing();

                    Position newPosition = null;
                    switch (facing) {
                        case N:
                            newPosition = new Position(x, y, W);
                            break;
                        case E:
                            newPosition = new Position(x, y, N);
                            break;
                        case S:
                            newPosition = new Position(x, y, E);
                            break;
                        case W:
                            newPosition = new Position(x, y, S);
                            break;
                    }
                    setRoverPosition(newPosition);
                    break;
                case R:
                    Position currentPosition2 = this.roverPosition;
                    int x2 = currentPosition2.x();
                    int y2 = currentPosition2.y();
                    CompassDirection facing2 = currentPosition2.facing();
                    Position newPosition2 = null;

                    switch (facing2) {
                        case N:
                            newPosition2 = new Position(x2, y2, E);
                            break;
                        case E:
                            newPosition2 = new Position(x2, y2, S);
                            break;
                        case S:
                            newPosition2 = new Position(x2, y2, W);
                            break;
                        case W:
                            newPosition2 = new Position(x2, y2, N);
                            break;
                    }
                    setRoverPosition(newPosition2);
                    break;

                case M:
                    Position currentPosition3 = this.roverPosition;
                    int x3 = currentPosition3.x();
                    int y3 = currentPosition3.y();
                    CompassDirection facing3 = currentPosition3.facing();
                    Position newPosition3 = null;

                    switch (facing3) {
                        case N:
                            newPosition3 = new Position(x3, y3 + 1, facing3);
                            break;
                        case E:
                            newPosition3 = new Position(x3 + 1, y3, facing3);
                            break;
                        case S:
                            newPosition3 = new Position(x3, y3 - 1, facing3);
                            break;
                        case W:
                            newPosition3 = new Position(x3 - 1, y3, facing3);
                            break;
                    }

                    setRoverPosition(newPosition3);
                    break;
            }
        }
    }
}
