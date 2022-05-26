package com.rover.geolocation;

public class North implements Cardinal {
    @Override
    public Cardinal right() {
        return new East();
    }

    @Override
    public Cardinal left() {
        return new West();
    }

    @Override
    public Position moveFrom(Position position) {
        return position.up();
    }

    @Override
    public String toString() {
        return "N";
    }
}
