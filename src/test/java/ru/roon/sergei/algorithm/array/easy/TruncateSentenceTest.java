package ru.roon.sergei.algorithm.array.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TruncateSentenceTest {

    @ParameterizedTest
    @MethodSource("data")
    void truncateSentence(String str, int k, String result) {
        TruncateSentence algorithm = new TruncateSentence();
        assertEquals(result, algorithm.truncateSentence(str, k));

    }

    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of("Hello how are you Contestant", 4 , "Hello how are you"),
            Arguments.of("What is the solution to this problem", 4 , "What is the solution"),
            Arguments.of("chopper is not a tanuki", 5 , "chopper is not a tanuki"));
    }
}