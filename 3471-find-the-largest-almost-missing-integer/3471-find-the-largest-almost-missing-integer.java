class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        if (k == 1) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int x : nums) count.put(x, count.getOrDefault(x, 0) + 1);
            int ans = -1;
            for (int key : count.keySet())
                if (count.get(key) == 1) ans = Math.max(ans, key);
            return ans;
        }

        if (k == n) {
            int ans = -1;
            for (int x : nums)
            ans = Math.max(ans, x);
            return ans;
        }

        int first = nums[0], last = nums[n - 1];
        boolean firstValid = true, lastValid = true;

        for (int i = 1; i < n; i++) 
        if (nums[i] == first) 
        firstValid = false;

        for (int i = 0; i < n - 1; i++)
         if (nums[i] == last) 
         lastValid = false;

        int ans = -1;
        if (firstValid) ans = Math.max(ans, first);
        if (lastValid) ans = Math.max(ans, last);
        return ans;
    }
}
