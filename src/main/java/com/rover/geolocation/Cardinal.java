package com.rover.geolocation;

public interface Cardinal {
    static Cardinal fromString(String cardinal) {
        return switch (cardinal) {
            case "N" -> new North();
            case "E" -> new East();
            case "S" -> new South();
            default -> new West();
        };
    }

    Cardinal right();

    Cardinal left();

    Position moveFrom(Position position);
}
