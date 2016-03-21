package com.epam.javauniversity.emergencypreventionsystem;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TestSector {

    @Test
    public void testSectorAnalyseOneGroup() {
        Sector sector = new Sector();

        sector.setCells(new Cell[][]{{new Cell(StateCell.FREE), new Cell(StateCell.BUSY), new Cell(StateCell.BUSY)},   // -xx
                                     {new Cell(StateCell.BUSY), new Cell(StateCell.FREE), new Cell(StateCell.BUSY)},   // x-x
                                     {new Cell(StateCell.BUSY), new Cell(StateCell.BUSY), new Cell(StateCell.BUSY)}}); // xxx

        sector.analyseSector();

        assertTrue(sector.getListGroupsPerson().size() == 1);
        assertTrue(sector.getListGroupsPerson().get(0).getCells().size() == 7);
        assertTrue(sector.getListGroupsPerson().get(0).getLevelRisk() == Risk.NORMAL);

    }
    @Test
    public void testSectorAnalyseTwoGroup() {
        Sector sector = new Sector();

        sector.setCells(new Cell[][]{{new Cell(StateCell.FREE), new Cell(StateCell.BUSY), new Cell(StateCell.FREE)},   // -x-
                                     {new Cell(StateCell.BUSY), new Cell(StateCell.FREE), new Cell(StateCell.FREE)},   // x--
                                     {new Cell(StateCell.BUSY), new Cell(StateCell.FREE), new Cell(StateCell.FREE)}}); // x--
        sector.analyseSector();

        assertTrue(sector.getListGroupsPerson().size() == 2 );

        assertTrue(sector.getListGroupsPerson().get(0).getCells().size() == 1);
        assertTrue(sector.getListGroupsPerson().get(0).getLevelRisk() == Risk.NONE);

        assertTrue(sector.getListGroupsPerson().get(1).getCells().size() == 2);
        assertTrue(sector.getListGroupsPerson().get(1).getLevelRisk() == Risk.NONE);
    }
}