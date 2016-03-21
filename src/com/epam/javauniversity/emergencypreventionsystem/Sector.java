package com.epam.javauniversity.emergencypreventionsystem;

import java.util.LinkedList;
import java.util.List;

public class Sector {
    private List<GroupPerson> listGroupsPerson;
    private Cell[][] cells;

    public Sector() {
        this.setListGroupsPerson(new LinkedList<>());
    }

    public Sector(int n, int m, double fillFactor) {
        if (n < 1 || m < 1 || fillFactor < 0 || fillFactor > 1) {
            throw new IllegalArgumentException("Arguments is incorrect");
        }
        setListGroupsPerson(new LinkedList<>());
        setCells(new Cell[n][m]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                getCells()[i][j] = new Cell(fillFactor);
            }
        }
    }

    public void analyseSector() {
        for (int i = 0; i < getCells().length; i++) {
            for (int j = 0; j < getCells()[0].length; j++) {
                crawl(i, j);
            }
        }
    }

    private void crawl(int i, int j) {
        if (getCells()[i][j].isBusy()) {
            if (getCells()[i][j].isNotInGroup()) {
                getCells()[i][j].createNewGroup();
                getListGroupsPerson().add(getCells()[i][j].getGroup());
            }
            if (j < getCells()[0].length - 1) {
                if (getCells()[i][j + 1].isBusyNotInGroup()) {
                    getCells()[i][j].joinCell(getCells()[i][j + 1]);
                    crawl(i, j + 1);
                }
            }
            if (i < getCells().length - 1) {
                if (getCells()[i + 1][j].isBusyNotInGroup()) {
                    getCells()[i][j].joinCell(getCells()[i + 1][j]);
                    crawl(i + 1, j);
                }
            }
            if (j > 0) {
                if (getCells()[i][j - 1].isBusyNotInGroup()) {
                    getCells()[i][j].joinCell(getCells()[i][j - 1]);
                    crawl(i, j - 1);
                }
            }
            if (i > 0) {
                if (getCells()[i - 1][j].isBusyNotInGroup()) {
                    getCells()[i][j].joinCell(getCells()[i - 1][j]);
                    crawl(i - 1, j);
                }
            }
        }
    }

    public List<GroupPerson> getListGroupsPerson() {
        return listGroupsPerson;
    }

    public void setListGroupsPerson(List<GroupPerson> listGroupsPerson) {
        if (listGroupsPerson == null) {
            throw new IllegalArgumentException("List groups person is null");
        }
        this.listGroupsPerson = listGroupsPerson;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        if (cells == null) {
            throw new IllegalArgumentException("Cells is null");
        }
        this.cells = cells;
    }
}
