package com.epam.javauniversity.emergencypreventionsystem;

import java.util.LinkedList;
import java.util.List;

public class GroupPerson {
    private List<Cell> cells;
    private Risk levelRisk;

    public GroupPerson(Cell cell) {
        setCells(new LinkedList<>());
        getCells().add(cell);
        setLevelRisk(Risk.NONE);
    }

    public void addCell(Cell cell) {
        cells.add(cell);
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public Risk getLevelRisk() {
        return levelRisk;
    }

    public void setLevelRisk(Risk levelRisk) {
        this.levelRisk = levelRisk;
    }
}
