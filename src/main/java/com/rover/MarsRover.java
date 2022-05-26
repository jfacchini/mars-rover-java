package com.rover;

import com.rover.geolocation.Cardinal;
import com.rover.geolocation.Position;

public class MarsRover {
    private Cardinal cardinal;
    private Position position;

    public MarsRover(int x, int y, String cardinal) {
        this.position = new Position(x, y);
        this.cardinal = Cardinal.fromString(cardinal);
    }

    public void execute(String input) {
        var commands = input.split("");

        for (var command : commands) {
            switch (command) {
                case "M" -> move();
                case "R" -> rotateRight();
                case "L" -> rotateLeft();
            }
        }
    }

    public void rotateLeft() {
        cardinal = cardinal.left();
    }

    public void rotateRight() {
        cardinal = cardinal.right();
    }

    public void move() {
        position = cardinal.moveFrom(position);
    }

    @Override
    public String toString() {
        return String.format("%s:%s", position, cardinal);
    }
}
