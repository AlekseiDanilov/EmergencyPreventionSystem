package com.epam.javauniversity.emergencypreventionsystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Report {
    private Map<Risk, Integer> numberGroups;

    public Report() {
        setNumberGroups(new HashMap<>());
    }

    public Report(List<GroupPerson> listGroupsPerson) {
        if (listGroupsPerson == null) {
            throw new IllegalArgumentException("List groups person is null");
        }
        setNumberGroups(new HashMap<>());
        for (Risk risk : Risk.values()) {
            getNumberGroups().put(risk, calcNumber(listGroupsPerson, risk));
        }
    }

    private Integer calcNumber(List<GroupPerson> listGroupsPerson, Risk risk) {
        if (risk == null) {
            throw new IllegalArgumentException("Risk is null");
        }
        int count = 0;
        for (GroupPerson groupPerson : listGroupsPerson) {
            if (groupPerson.getLevelRisk().equals(risk)) {
                count++;
            }
        }
        return count;
    }

    public void printReport() {
        System.out.println("Risk group report:");
        System.out.println("----------------------------------------------------------------------");
        for (Map.Entry<Risk, Integer> entry : getNumberGroups().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " groups");
        }
    }

    public Map<Risk, Integer> getNumberGroups() {
        return numberGroups;
    }

    public void setNumberGroups(Map<Risk, Integer> numberGroups) {
        this.numberGroups = numberGroups;
    }
}
