package ru.roon.sergei.algorithm.string.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumNumberOfOperationsToMoveAllBallsToEachBoxTest {

    @ParameterizedTest
    @MethodSource("boxes")
    void minOperations(String box, int[] answer) {
        MinimumNumberOfOperationsToMoveAllBallsToEachBox algorithm = new MinimumNumberOfOperationsToMoveAllBallsToEachBox();
        int[] result = algorithm.minOperations(box);
        assertEquals(answer.length, result.length);
        for (int i = 0; i < answer.length; i++) {
            assertEquals(answer[i], result[i]);
        }
    }


    private static Stream<Arguments> boxes() {
        return Stream.of(
            Arguments.of(
                "001011",
                new int[]{11, 8, 5, 4, 3, 4}),
            Arguments.of(
                "110",
                new int[]{1, 1, 3})
        );
    }
}