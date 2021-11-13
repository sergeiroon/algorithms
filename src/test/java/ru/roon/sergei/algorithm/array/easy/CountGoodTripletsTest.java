package ru.roon.sergei.algorithm.array.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountGoodTripletsTest {

    @ParameterizedTest
    @MethodSource("data")
    void countGoodTriplets(int[] nums, int a, int b, int c, int result) {
        CountGoodTriplets algorithm = new CountGoodTriplets();
        assertEquals(result, algorithm.countGoodTriplets(nums, a, b, c));
    }

    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3, 4),
            Arguments.of(new int[]{1, 1, 2, 2, 3}, 0, 0, 1, 0));
    }
}