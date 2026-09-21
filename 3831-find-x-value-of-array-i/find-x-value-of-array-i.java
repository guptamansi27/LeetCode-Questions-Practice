class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];

        // dp[r] = number of subarrays ending at previous position
        // whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {

            int mod = num % k;

            // New DP for subarrays ending at current num
            long[] newDp = new long[k];

            // Start a new subarray containing only num
            newDp[mod] = 1;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {

                int newRemainder = (int)((long) r * mod % k);

                newDp[newRemainder] += dp[r];
            }

            // Add current subarrays to final answer
            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }

            // Move to next position
            dp = newDp;
        }

        return result;
    }
}