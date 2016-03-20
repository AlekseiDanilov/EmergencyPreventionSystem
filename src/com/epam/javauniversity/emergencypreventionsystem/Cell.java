package com.epam.javauniversity.emergencypreventionsystem;

public class Cell {
    private StateCell state;
    private GroupPerson group;

    public Cell(StateCell state) {
        if (state == null) {
            throw new IllegalArgumentException("State is null");
        }
        this.setState(state);
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
}
