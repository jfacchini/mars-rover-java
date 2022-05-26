package com.rover;

public class TurnRightCommand implements Command {
    private final MarsRover rover;

    public TurnRightCommand(MarsRover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.rotateRight();
    }
}
