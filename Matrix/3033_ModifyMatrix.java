class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int[][] ans = matrix.clone();
        for (int j = 0; j < matrix[0].length; ++j) {
        int max = 0;
        for (int i = 0; i < matrix.length; ++i)
            max = Math.max(max, matrix[i][j]);
        for (int i = 0; i < matrix.length; ++i)
            if (matrix[i][j] == -1)
            ans[i][j] = max;
        }
        return ans;
    }
}