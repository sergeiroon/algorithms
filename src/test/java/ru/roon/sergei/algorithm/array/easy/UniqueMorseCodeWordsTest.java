package ru.roon.sergei.algorithm.array.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UniqueMorseCodeWordsTest {

    @ParameterizedTest
    @MethodSource("data")
    void uniqueMorseRepresentations(String[] words, int result) {
        UniqueMorseCodeWords algorithm = new UniqueMorseCodeWords();
        assertEquals(result, algorithm.uniqueMorseRepresentations(words));
    }

    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new String[]{"gin","zen","gig","msg"}, 2),
            Arguments.of(new String[]{"a"}, 1));
    }
}