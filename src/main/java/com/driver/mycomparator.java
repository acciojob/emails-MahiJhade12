package com.driver;

import java.util.Comparator;

class mycomparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting o1, Meeting o2) {
        return o1.getEndTime().compareTo(o2.getEndTime());
    }
}