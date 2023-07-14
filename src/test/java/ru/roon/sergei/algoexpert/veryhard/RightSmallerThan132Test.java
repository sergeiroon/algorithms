package ru.roon.sergei.algoexpert.veryhard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RightSmallerThan132Test {

    @Test
    void rightSmallerThanTest() {
        RightSmallerThan132 rightSmallerThan132 = new RightSmallerThan132();
        int[] array = new int[]{8,5,11,-1,3,4,2};
        int[] expected = new int[]{5,4,4,0,1,1,0};
        assertArrayEquals(expected, rightSmallerThan132.rightSmallerThan(array));
    }
}