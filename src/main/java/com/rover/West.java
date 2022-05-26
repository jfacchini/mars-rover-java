package com.rover;

public class West implements Cardinal {
    @Override
    public Cardinal right() {
        return new North();
    }

    @Override
    public Cardinal left() {
        return new South();
    }

    @Override
    public Position moveFrom(Position position) {
        return position.left();
    }

    @Override
    public String toString() {
        return "W";
    }
}
