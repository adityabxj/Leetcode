import java.util.List;

public class HourlyGlassMaxSum {

    public static int hourglassSum(List<List<Integer>> arr) {
        int[][] a = arr.stream().map(l -> l.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        int maxsum = a[0][0] + a[0][1] + a[0][2]
                + a[1][1]
                + a[2][0] + a[2][1] + a[2][2];
        for (int i = 1; i < a.length - 1; i++) {
            for (int j = 1; j < a[i].length - 1; j++) {
                int sum = a[i - 1][j - 1] + a[i - 1][j] + a[i - 1][j + 1]
                        + a[i][j]
                        + a[i + 1][j - 1] + a[i + 1][j] + a[i + 1][j + 1];
                if (sum > maxsum) {
                    maxsum = sum;
                }
            }
        }
        return maxsum;
    }

}