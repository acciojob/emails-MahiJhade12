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

        LocalTime time_limit = LocalTime.ofSecondOfDay(0);
        int count = 1;
        mycomparator mc = new mycomparator();
        Collections.sort(calendar, mc);
        for (int i = 1; i < calendar.size(); i++) {

            if (calendar.get(i).getStartTime().compareTo(time_limit) > 0) {
                count++;
                time_limit = calendar.get(i).getEndTime();
            }

        }
        return count;
    }
}
