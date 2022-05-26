package com.rover;

public class RemoteButton {

    private final Command command;

    RemoteButton(Command command) {
        this.command = command;
    }

    public void pressed() {
        command.execute();
    }
}
