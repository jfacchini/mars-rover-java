package com.rover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverShould {
    @ParameterizedTest
    @CsvSource({"1, 2, N, '1:2:N'", "2, 3, S, '2:3:S'"})
    void return_initial_position_of_rover_without_any_command(int x, int y, String cardinal, String expectedState) {
        String emptyCommand = "";
        MarsRover rover = new MarsRover(x, y, cardinal);

        rover.execute(emptyCommand);

        assertEquals(expectedState, rover.toString());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, N, M, '1:3:N'",
        "1, 2, N, MM, '1:4:N'",
        "1, 4, S, MM, '1:2:S'"
    })
    void move_vertically(int x, int y, String cardinal, String commands, String expectedState) {
        MarsRover rover = new MarsRover(x, y, cardinal);

        rover.execute(commands);

        assertEquals(expectedState, rover.toString());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, E, M, '2:2:E'",
        "1, 2, E, MM, '3:2:E'",
        "3, 2, W, MM, '1:2:W'"
    })
    void move_horizontally(int x, int y, String cardinal, String commands, String expectedState) {
        MarsRover rover = new MarsRover(x, y, cardinal);

        rover.execute(commands);

        assertEquals(expectedState, rover.toString());
    }

    @ParameterizedTest
    @CsvSource({
        "N, R, E",
        "N, RR, S",
        "N, RRR, W",
        "N, RRRR, N",
        "N, L, W",
        "N, LL, S",
        "N, LLL, E",
        "N, LLLL, N"
    })
    void turns_to_the_expected_direction(String cardinal, String commands, String expectedCardinal) {
        MarsRover rover = new MarsRover(0, 0, cardinal);

        rover.execute(commands);

        assertEquals(String.format("0:0:%s",expectedCardinal), rover.toString());
    }

    @Test
    void should_be_moved_from_a_remote() {
        var rover = new MarsRover(0, 0, "N");
        Command moveCommand = new MoveCommand(rover);
        Command turnRightCommand = new TurnRightCommand(rover);
        Command turnLeftCommand = new TurnLeftCommand(rover);

        var remoteMove = new RemoteButton(moveCommand);
        var remoteRight = new RemoteButton(turnRightCommand);
        var remoteLeft = new RemoteButton(turnLeftCommand);

        remoteMove.pressed();
        remoteRight.pressed();
        remoteMove.pressed();
        remoteLeft.pressed();
        remoteMove.pressed();

        assertEquals("1:2:N", rover.toString());
    }
}
