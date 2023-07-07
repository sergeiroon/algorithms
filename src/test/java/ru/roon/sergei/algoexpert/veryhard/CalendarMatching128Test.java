package ru.roon.sergei.algoexpert.veryhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalendarMatching128Test {

    @Test
    void calendarMatching() {
        var calendarMatching128 = new CalendarMatching128();
        List<String[]> calendarOne = new ArrayList<>();
        calendarOne.add(new String[]{"9:00", "10:30"});
        calendarOne.add(new String[]{"12:00", "13:00"});
        calendarOne.add(new String[]{"16:00", "18:00"});
        String[] dailyBoundsOne = new String[]{"9:00", "20:00"};
        List<String[]> calendarTwo = new ArrayList<>();
        calendarTwo.add(new String[]{"10:00", "11:30"});
        calendarTwo.add(new String[]{"12:30", "14:30"});
        calendarTwo.add(new String[]{"14:30", "15:00"});
        calendarTwo.add(new String[]{"16:00", "17:00"});
        String[] dailyBoundsTwo = new String[]{"10:00", "18:30"};
        int meetingDuration = 30;
        List<String[]> result = calendarMatching128.calendarMatching(calendarOne, dailyBoundsOne, calendarTwo, dailyBoundsTwo, meetingDuration);
        List<String[]> expected = new ArrayList<>();
        expected.add(new String[]{"11:30", "12:00"});
        expected.add(new String[]{"15:00", "16:00"});
        expected.add(new String[]{"18:00", "18:30"});
        assertEquals(expected.size(), result.size());

        for (int i = 0; i < result.size(); i++) {
            assertArrayEquals(expected.get(i), result.get(i));
        }
    }
}