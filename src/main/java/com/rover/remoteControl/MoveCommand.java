package com.rover.remoteControl;

import com.rover.MarsRover;

public class MoveCommand implements Command {
    private final MarsRover rover;

    public MoveCommand(MarsRover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        this.rover.move();
    }
}
