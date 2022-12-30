package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.*;

public class Workspace extends Gmail {

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public ArrayList<Meeting> getCalendar() {
        return calendar;
    }

    public Workspace(String emailId) {
        super(emailId, Integer.MAX_VALUE);
        this.calendar = new ArrayList<>();

        // The inboxCapacity is equal to the maximum value an integer can store.
    }


    public void addMeeting(Meeting meeting) {
        //add the meeting to calendar
        calendar.add(meeting);

    }

    public int findMaxMeetings() {

        ArrayList<Pair<LocalTime, Integer>> endTimes = new ArrayList<>();

        for (int i = 0; i < calendar.size(); i++) {
            endTimes.add(Pair.of(calendar.get(i).getEndTime(), i));
        }

        Collections.sort(endTimes);

        LocalTime time_limit = endTimes.get(0).getLeft();

        int cnt = 0;
        if (!endTimes.isEmpty()) {
            cnt += 1;
        }

        for (int i = 1; i < endTimes.size(); i++) {
            if (calendar.get(endTimes.get(i).getRight()).getStartTime().compareTo(time_limit) > 0) {

                cnt += 1;
                time_limit = endTimes.get(i).getLeft();
            }
        }

        return cnt;
    }
}