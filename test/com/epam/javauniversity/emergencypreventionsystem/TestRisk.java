package com.epam.javauniversity.emergencypreventionsystem;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestRisk {

    @Test
    public void testGetNextLevelRisk() {
        assertEquals(Risk.NONE.getNextLevelRisk(), Risk.MINOR);
    }

    @Test
    public void testGetNextLevelRiskLastLevel() {
        assertEquals(Risk.CRITICAL.getNextLevelRisk(), Risk.CRITICAL);
    }
}