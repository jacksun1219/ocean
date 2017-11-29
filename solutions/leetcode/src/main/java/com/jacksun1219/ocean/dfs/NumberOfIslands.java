package com.jacksun1219.ocean.dfs;

/**
 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1
 */
public class NumberOfIslands {

    // Time complexity: O(mn)  Use dfs to traverse whole map, and each point will be visited at most once,
    // so the time complexity is O(mn), where m is rows of map, n is cols of map.
    // Space complexity: O(mn) The dominate space consumption is to use a 2-D array to
    // record whether the grid is visited or not. This is larger than stack space consumption.
    public int numDistinctIslands(int[][] grid) {
        // Sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            throw new IllegalArgumentException();
        }

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited  = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    dfs(i, j, visited, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, boolean[][] visited, int[][] grid) {
        int[] di = new int[]{1, 0, -1, 0};
        int[] dj = new int[]{0, -1, 0, 1};
        for (int k = 0; k < 4; k++) {
            int newI = i + di[k];
            int newJ = j + dj[k];
            if (isValid(newI, newJ, grid, visited)) {
                visited[newI][newJ] = true;
                dfs(newI, newJ, visited, grid);
            }
        }
    }

    private boolean isValid(int i, int j, int[][] grid, boolean[][] visited) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length
                && !visited[i][j] && grid[i][j] == 1) {
            return true;
        }
        return false;
    }
}
