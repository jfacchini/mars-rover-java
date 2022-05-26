package com.rover;

public class MarsRover {
    private Cardinal cardinal;
    private Position position;

    public MarsRover(int x, int y, String cardinal) {
        this.position = new Position(x, y);
        this.cardinal = Cardinal.fromString(cardinal);
    }

    public String execute(String input) {
        var commands = input.split("");

        for (var command : commands) {
            switch (command) {
                case "M" -> move();
                case "R" -> rotateRight();
                case "L" -> rotateLeft();
            }
        }

        return String.format("%s:%s", position, cardinal);
    }

    private void rotateLeft() {
        cardinal = cardinal.left();
    }

    private void rotateRight() {
        cardinal = cardinal.right();
    }

    private void move() {
        position = cardinal.moveFrom(position);
    }

}
