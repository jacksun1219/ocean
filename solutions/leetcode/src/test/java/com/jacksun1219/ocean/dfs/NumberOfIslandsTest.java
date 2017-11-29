package com.jacksun1219.ocean.dfs;

import com.jacksun1219.ocean.util.GridUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberOfIslandsTest {

    public NumberOfIslands subject;

    @Before
    public void setUp() {
        subject = new NumberOfIslands();
    }

    @Test
    public void numDistinctIslandsTest_withOne() {
        int[][] grid = getGrid("11110\n" +
                "11010\n" +
                "11000\n" +
                "00000");

        Assert.assertEquals(1, subject.numDistinctIslands(grid));
    }

    @Test
    public void numDistinctIslandsTest_withTwo() {
        int[][] grid = getGrid("11110\n" +
                "11010\n" +
                "11000\n" +
                "00001");

        Assert.assertEquals(2, subject.numDistinctIslands(grid));
    }


    private int[][] getGrid(String string) {
        return GridUtil.getArray(GridUtil.getGrid(string));
    }

}