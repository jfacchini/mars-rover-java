package com.rover;

public class East implements Cardinal {
    @Override
    public Cardinal right() {
        return new South();
    }

    @Override
    public Cardinal left() {
        return new North();
    }

    @Override
    public Position moveFrom(Position position) {
        return position.right();
    }

    @Override
    public String toString() {
        return "E";
    }
}
