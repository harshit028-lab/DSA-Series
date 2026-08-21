class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long l = 1, r = (long)1e11;
        while (l < r) {
            long mid = (l + r) / 2;
            if (check(coins, mid, k)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    private boolean check(int[] coins, long mx, int k) {
        int n = coins.length;
        long cnt = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            long v = 1;
            for (int j = 0; j < n; j++) {
                if ((mask >> j & 1) == 1) {
                    v = lcm(v, coins[j]);
                    if (v > mx) break;
                }
            }
            int bits = Integer.bitCount(mask);
            if ((bits & 1) == 1) cnt += mx / v;
            else cnt -= mx / v;
        }
        return cnt >= k;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
