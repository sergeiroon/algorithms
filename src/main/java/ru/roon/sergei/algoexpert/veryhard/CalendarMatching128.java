package ru.roon.sergei.algoexpert.veryhard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Задача: даны два расписания на день и два промежутка работы, так же дан промежуток времени в минутах, необходимо
 * найти все промежутки которые свободны в обоих расписаниях и в которые поместился бы указанный промежуток времени.
 * Пример: [9:00-10:30, 12:00-13:00, 16:00-18:00],9:00-20:00,
 * [10:00-11:30, 12:30-14:30, 14:30-15:00, 16:00-17:00],10:00-18:30,
 * 30
 */
public class CalendarMatching128 {


    public List<String[]> calendarMatching(List<String[]> calendarOne, String[] dailyBoundsOne,
                                           List<String[]> calendarTwo, String[] dailyBoundsTwo,
                                           int meetingDuration) {
        List<int[]> updatedCalendarOne = updateCalendar(calendarOne, dailyBoundsOne);
        List<int[]> updatedCalendarTwo = updateCalendar(calendarTwo, dailyBoundsTwo);
        List<int[]> mergedCalendars = mergeCalendars(updatedCalendarOne, updatedCalendarTwo);
        List<int[]> flattenedCalendar = flattenCalendar(mergedCalendars);
        return getMatchingAvailabilities(flattenedCalendar, meetingDuration);
    }

    private List<String[]> getMatchingAvailabilities(List<int[]> calendar, int meetingDuration) {
        List<int[]> matchingAvailabilities = new ArrayList<>();
        for (int i = 1; i < calendar.size(); i++) {
            int start = calendar.get(i - 1)[1];
            int end = calendar.get(i)[0];
            int availabilitiesDuration = end - start;
            if (availabilitiesDuration >= meetingDuration) {
                matchingAvailabilities.add(new int[]{start, end});
            }
        }
        return matchingAvailabilities
            .stream()
            .map(integers -> new String[]{minutesToString(integers[0]), minutesToString(integers[1])})
            .collect(Collectors.toList());
    }

    private String minutesToString(int integer) {
        int hours = integer / 60;
        int minutes = integer % 60;
        String hoursString = String.valueOf(hours);
        String minutesString = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
        return hoursString + ":" + minutesString;
    }

    private List<int[]> flattenCalendar(List<int[]> calendar) {
        List<int[]> flattened = new ArrayList<>();
        flattened.add(calendar.get(0));

        for (int i = 1; i < calendar.size(); i++) {
            int[] currentMeeting = calendar.get(i);
            int[] previousMeeting = flattened.get(flattened.size() - 1);
            int currentStart = currentMeeting[0];
            int currentEnd = currentMeeting[1];
            int previousStart = previousMeeting[0];
            int previousEnd = previousMeeting[1];
            if (previousEnd >= currentStart) {
                int[] newPreviousMeeting = new int[]{previousStart, Math.max(previousEnd, currentEnd)};
                flattened.remove(flattened.size() - 1);
                flattened.add(newPreviousMeeting);
            } else {
                flattened.add(new int[]{currentMeeting[0], currentMeeting[1]});
            }
        }
        return flattened;
    }

    private List<int[]> mergeCalendars(List<int[]> calendarOne, List<int[]> calendarTwo) {
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < calendarOne.size() && j < calendarTwo.size()) {
            int[] meetingOne = calendarOne.get(i);
            int[] meetingTwo = calendarTwo.get(j);
            if (meetingOne[0] < meetingTwo[0]) {
                merged.add(meetingOne);
                i += 1;
            } else {
                merged.add(meetingTwo);
                j += 1;
            }
        }
        while (i < calendarOne.size()) {
            merged.add(calendarOne.get(i));
            i += 1;
        }
        while (j < calendarTwo.size()) {
            merged.add(calendarTwo.get(j));
            j += 1;
        }
        return merged;
    }

    private List<int[]> updateCalendar(List<String[]> calendarOne, String[] dailyBoundsOne) {
        List<String[]> updatedCalendar = new ArrayList<>(calendarOne);
        updatedCalendar.add(0, new String[]{"0:00", dailyBoundsOne[0]});
        updatedCalendar.add(new String[]{dailyBoundsOne[1], "23:59"});
        return updatedCalendar
            .stream()
            .map(strings -> new int[]{timeToMinutes(strings[0]), timeToMinutes(strings[1])})
            .collect(Collectors.toList());

    }

    private int timeToMinutes(String string) {
        String[] hoursAndMinutes = string.split(":");
        int hours = Integer.parseInt(hoursAndMinutes[0]);
        int minutes = Integer.parseInt(hoursAndMinutes[1]);
        return hours * 60 + minutes;
    }
}
