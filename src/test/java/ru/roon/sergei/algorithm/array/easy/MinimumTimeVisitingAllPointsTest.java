package ru.roon.sergei.algorithm.array.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinimumTimeVisitingAllPointsTest {

    @ParameterizedTest
    @MethodSource("data")
    void minTimeToVisitAllPoints(int[][] matrix, int result) {
        MinimumTimeVisitingAllPoints algorithm = new MinimumTimeVisitingAllPoints();
        assertEquals(result, algorithm.minTimeToVisitAllPoints(matrix));
    }

    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[][]{{1,1},{3,4},{-1,0}}, 7),
            Arguments.of(new int[][]{{3,2},{-2,2}}, 5));
    }
}