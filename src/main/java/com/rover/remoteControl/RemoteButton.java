package com.rover.remoteControl;

public class RemoteButton {

    private final Command command;

    public RemoteButton(Command command) {
        this.command = command;
    }

    public void pressed() {
        command.execute();
    }
}
