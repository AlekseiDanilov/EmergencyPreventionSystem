package com.epam.javauniversity.emergencypreventionsystem;

public enum Risk {

    NONE(1, 2),
    MINOR(3, 4),
    NORMAL(5, 7),
    MAJOR(8, 13),
    CRITICAL(14);

    private final int minimumNumberPerson;
    private final int maximumNumberPerson;

    Risk(int minimumNumberPerson, int maximumNumberPerson) {
        this.minimumNumberPerson = minimumNumberPerson;
        this.maximumNumberPerson = maximumNumberPerson;
    }

    Risk(int minimumNumberPerson) {
        this.minimumNumberPerson = minimumNumberPerson;
        this.maximumNumberPerson = Integer.MAX_VALUE;
    }

    public Risk getNextLevelRisk() {
        Risk[] levelsRisk = Risk.values();
        if (this.ordinal() == levelsRisk.length - 1) {
            return levelsRisk[this.ordinal()];
        }
        return levelsRisk[this.ordinal() + 1];
    }

    public int getMaximumNumberPerson() {
        return this.maximumNumberPerson;
    }

    public static void printLevelsRisk() {
        System.out.println("Levels risk:");
        System.out.println("----------------------------------------------------------------------");
        for (Risk levelRisk : Risk.values()) {
            if (levelRisk == Risk.CRITICAL) {
                System.out.println(levelRisk + ": > " + levelRisk.minimumNumberPerson);
            } else {
                System.out.println(levelRisk + ": " + levelRisk.getMaximumNumberPerson());
            }
        }
    }
}
