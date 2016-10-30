package com.epam.javauniversity.emergencypreventionsystem;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestCell {
    @Test
    public void testCellJoinCell() {
        Cell oneCell = new Cell(StateCell.FREE);
        oneCell.setGroup(new GroupPerson());
        Cell twoCell = new Cell(StateCell.BUSY);
        oneCell.joinCell(twoCell);

        assertTrue(oneCell.getGroup() == twoCell.getGroup());
    }

    @Test
    public void testCellCreateNewGroup() {
        Cell cell = new Cell(StateCell.FREE);
        assertNull(cell.getGroup());
        cell.createNewGroup();
        assertNotNull(cell.getGroup());
    }

    @Test
    public void testCellIsBusy() {
        assertTrue(new Cell(StateCell.BUSY).isBusy());
    }

    @Test
    public void testCellIsFree() {
        assertTrue(new Cell(StateCell.FREE).isFree());
    }

    @Test
    public void testCellIsNotGroup() {
        assertTrue(new Cell(StateCell.FREE).isNotInGroup());
    }
    @Test
    public void testCellIsBusyNotInGroup() {
        assertTrue(new Cell(StateCell.BUSY).isBusyNotInGroup());
    }
}