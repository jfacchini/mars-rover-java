package com.rover.geolocation;

public enum Cardinal {

    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static Cardinal fromString(String cardinal) {
        return switch (cardinal) {
            case "N" -> Cardinal.NORTH;
            case "E" -> Cardinal.EAST;
            case "S" -> Cardinal.SOUTH;
            case "W" -> Cardinal.WEST;
            default -> throw new IllegalStateException("Unexpected value: " + cardinal);
        };
    }

    public Cardinal right() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    public Cardinal left() {
        return switch (this) {
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            case EAST -> NORTH;
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }
}
