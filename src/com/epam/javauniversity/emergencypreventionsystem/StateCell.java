package com.epam.javauniversity.emergencypreventionsystem;

public enum StateCell {
    BUSY("|X|"),
    FREE(" - ");

    private final String mark;

    StateCell(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return this.mark;
    }
}
