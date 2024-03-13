package DP;

import java.util.Arrays;

class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m + 1][n][n];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return maxCherries(grid, dp, 0, 0, n - 1);
    }

    private int maxCherries(int[][] grid, int[][][] dp, int x, int y1, int y2) {
        if (x == grid.length || y1 < 0 || y1 >= grid[0].length || y2 < 0 || y2 >= grid[0].length) {
            return 0;
        }

        if (dp[x][y1][y2] != -1) {
            return dp[x][y1][y2];
        }

        int cherries = 0;
        cherries += grid[x][y1];
        if (y1 != y2) {
            cherries += grid[x][y2];
        }

        int maxCherries = 0;
        for (int d1 = -1; d1 <= 1; ++d1) {
            for (int d2 = -1; d2 <= 1; ++d2) {
                int newCol1 = y1 + d1;
                int newCol2 = y2 + d2;

                if (newCol1 >= 0 && newCol1 < grid[0].length && newCol2 >= 0 && newCol2 < grid[0].length) {
                    maxCherries = Math.max(maxCherries, maxCherries(grid, dp, x + 1, newCol1, newCol2));
                }
            }
        }

        return dp[x][y1][y2] = cherries + maxCherries;
    }
}