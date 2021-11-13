package ru.roon.sergei.algorithm.array.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumProductDifferenceBetweenTwoPairsTest {

    @ParameterizedTest
    @MethodSource("data")
    void maxProductDifference(int[] nums, int result) {
        MaximumProductDifferenceBetweenTwoPairs algorithm = new MaximumProductDifferenceBetweenTwoPairs();

        assertEquals(result, algorithm.maxProductDifference(nums));
    }

    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{5, 6, 2, 7, 4}, 34),
            Arguments.of(new int[]{4, 2, 5, 9, 7, 4, 8}, 64));
    }
}