package ru.roon.sergei.algorithm.array.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountTheNumberOfConsistentStringsTest {

    @ParameterizedTest
    @MethodSource("data")
    void countConsistentStrings(String str, String[] words, int count) {

        CountTheNumberOfConsistentStrings algorithm = new CountTheNumberOfConsistentStrings();

        assertEquals(count, algorithm.countConsistentStrings(str, words));
    }

    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}, 2),
            Arguments.of("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}, 7),
            Arguments.of("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}, 4));
    }
}