package com.rover;

public class South implements Cardinal {
    @Override
    public Cardinal right() {
        return new West();
    }

    @Override
    public Cardinal left() {
        return new East();
    }

    @Override
    public Position moveFrom(Position position) {
        return position.down();
    }

    @Override
    public String toString() {
        return "S";
    }
}
