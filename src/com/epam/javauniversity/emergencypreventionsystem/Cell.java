package com.epam.javauniversity.emergencypreventionsystem;

public class Cell {
    private StateCell state;
    private GroupPerson group;

    public Cell(double fillFactor) {
        if (Math.random() <= fillFactor) {
            this.state = StateCell.BUSY;
        } else {
            this.state = StateCell.FREE;
        }
    }

    public Cell(StateCell state) {
        if (state == null) {
            throw new IllegalArgumentException("State is null");
        }
        setState(state);
    }

    public void joinCell(Cell cell) {
        if (cell == null) {
            throw new IllegalArgumentException("Cell is null");
        }
        cell.setGroup(this.getGroup());
        this.group.addCell(cell);
    }

    public void createNewGroup() {
        this.setGroup(new GroupPerson(this));
    }

    public boolean isBusy() {
        return state == StateCell.BUSY;
    }

    public boolean isFree() {
        return state == StateCell.FREE;
    }

    public boolean isNotInGroup() {
        return this.group == null;
    }

    public boolean isBusyNotInGroup() {
        return isBusy() && isNotInGroup();
    }

    public StateCell getState() {
        return state;
    }

    public void setState(StateCell state) {
        if (state == null) {
            throw new IllegalArgumentException("State cell is null");
        }
        this.state = state;
    }

    public GroupPerson getGroup() {
        return group;
    }

    public void setGroup(GroupPerson group) {
        if (group == null) {
            throw new IllegalArgumentException("Group is null");
        }
        this.group = group;
    }

    @Override
    public String toString() {
        return state.toString() + "\t";
    }
}
