package ru.roon.sergei.algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SurroundedRegionsTest {

    @ParameterizedTest
    @MethodSource("boards")
    void solveTwo(char[][] board, char[][] expected) {
        SurroundedRegions algorithm = new SurroundedRegions();
        algorithm.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                assertEquals(expected[i][j], board[i][j]);
            }
        }
    }


    private static Stream<Arguments> boards() {
        return Stream.of(
            Arguments.of(
                new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}},
                new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}}),
            Arguments.of(
                new char[][]{{'O', 'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X', 'O'}, {'X', 'O', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'}, {'X', 'X', 'O', 'X', 'O'}},
                new char[][]{{'O', 'X', 'X', 'O', 'X'}, {'X', 'X', 'X', 'X', 'O'}, {'X', 'X', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'}, {'X', 'X', 'O', 'X', 'O'}}),
            Arguments.of(
                new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}},
                new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}}),
            Arguments.of(
                new char[][]{{'X', 'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'O', 'X'}, {'X', 'X', 'O', 'O', 'X'}, {'X', 'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X', 'X'}},
                new char[][]{{'X', 'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X', 'X'}}),

            Arguments.of(
                new char[][]{{'O', 'O', 'O', 'O', 'X', 'X'}, {'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'X', 'O', 'X', 'O', 'O'}, {'O', 'X', 'O', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'O'}, {'O', 'X', 'O', 'O', 'O', 'O'}},
                new char[][]{{'O', 'O', 'O', 'O', 'X', 'X'}, {'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'X', 'O', 'X', 'O', 'O'}, {'O', 'X', 'O', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'O'}, {'O', 'X', 'O', 'O', 'O', 'O'}})

        );
    }
}