class Solution {
    static String longestSubstring(String s, int n) {
        int[][] dp = new int[n + 1][n + 1];

        int maxlen = 0;
        int endpos = 0;

        for (int i = 1; i <= n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && dp[i - 1][j - 1] < j - i) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxlen) {
                        maxlen = dp[i][j];
                        endpos = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        if (maxlen == 0)
            return "-1";

        return s.substring(endpos - maxlen, endpos);
    }
};