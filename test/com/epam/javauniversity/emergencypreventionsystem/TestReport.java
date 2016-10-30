package com.epam.javauniversity.emergencypreventionsystem;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TestReport {

    @Test
    public void testReportCalcNumberGroups() {
        List<GroupPerson> list = new LinkedList<>();
        GroupPerson groupPerson = new GroupPerson(new Cell(StateCell.BUSY));
        list.add(groupPerson);

        Report report = new Report(list);

        Map<Risk, Integer> map = new HashMap<>();
        map.put(Risk.NONE, 1);
        map.put(Risk.CRITICAL, 0);
        map.put(Risk.MAJOR, 0);
        map.put(Risk.MINOR, 0);
        map.put(Risk.NORMAL, 0);

        assertEquals(map, report.getNumberGroups());
    }
}