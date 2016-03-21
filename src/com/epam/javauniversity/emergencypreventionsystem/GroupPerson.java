package com.epam.javauniversity.emergencypreventionsystem;

import java.util.LinkedList;
import java.util.List;

public class GroupPerson {
    private List<Cell> cells;
    private Risk levelRisk;

    public GroupPerson() {
        cells = new LinkedList<>();
        levelRisk = Risk.NONE;
    }

    public GroupPerson(Cell cell) {
        if (cell == null) {
            throw new IllegalArgumentException("Cell is null");
        }
        setCells(new LinkedList<>());
        getCells().add(cell);
        setLevelRisk(Risk.NONE);
    }

    public void addCell(Cell cell) {
        if (cell == null) {
            throw new IllegalArgumentException("Cell is null");
        }
        cells.add(cell);
        if (cells.size() > levelRisk.getMaximumNumberPerson()) {
            levelRisk = levelRisk.getNextLevelRisk();
        }
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        if (cells == null) {
            throw new IllegalArgumentException("Cells is null");
        }
        this.cells = cells;
    }

    public Risk getLevelRisk() {
        return levelRisk;
    }

    public void setLevelRisk(Risk levelRisk) {
        if (levelRisk == null) {
            throw new IllegalArgumentException("Level risk is null");
        }
        this.levelRisk = levelRisk;
    }
}
