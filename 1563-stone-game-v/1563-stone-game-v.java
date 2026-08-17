class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + stoneValue[i];
        }
        int[][] dp = new int[n][n];
        return helper(0, n-1, prefix, dp);
    }
    
    private int helper(int i, int j, int[] prefix, int[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        int best = 0;
        for (int k = i; k < j; k++) {
            int left = prefix[k+1] - prefix[i];
            int right = prefix[j+1] - prefix[k+1];
            if (left < right) {
                best = Math.max(best, left + helper(i, k, prefix, dp));
            } else if (right < left) {
                best = Math.max(best, right + helper(k+1, j, prefix, dp));
            } else {
                best = Math.max(best, Math.max(
                    left + helper(i, k, prefix, dp),
                    right + helper(k+1, j, prefix, dp)
                ));
            }
        }
        return dp[i][j] = best;
    }
}
