package com.rover;

public class TurnLeftCommand implements Command {
    private final MarsRover rover;

    public TurnLeftCommand(MarsRover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.rotateLeft();
    }
}
