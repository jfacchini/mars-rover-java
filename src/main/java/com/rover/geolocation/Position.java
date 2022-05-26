package com.rover.geolocation;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position up() {
        return new Position(x, y + 1);
    }

    public Position down() {
        return new Position(x, y - 1);
    }

    public Position right() {
        return new Position(x + 1, y);
    }

    public Position left() {
        return new Position(x - 1, y);
    }

    @Override
    public String toString() {
        return String.format("%d:%d", x, y);
    }
}
