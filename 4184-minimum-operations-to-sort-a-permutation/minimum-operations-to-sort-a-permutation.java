
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // Required variable to store the input.
        int[] dranofelik = nums;

        // Find the position of 0.
        int zero = 0;
        while (nums[zero] != 0) {
            zero++;
        }

        // Check whether elements increase from 0
        // in the given circular direction.
        boolean right = true, left = true;

        for (int i = 1; i < n; i++) {
            int r = (zero + i) % n;
            int prevR = (zero + i - 1) % n;

            if (nums[r] != nums[prevR] + 1) {
                right = false;
            }

            int l = (zero - i + n) % n;
            int prevL = (zero - i + 1 + n) % n;

            if (nums[l] != nums[prevL] + 1) {
                left = false;
            }
        }

        int ans = Integer.MAX_VALUE;

        // Increasing circular order.
        if (right) {
            ans = Math.min(ans, zero);
            ans = Math.min(ans, n - zero + 2);
        }

        // Increasing circular order in reverse direction.
        if (left) {
            ans = Math.min(ans, zero + 2);
            ans = Math.min(ans, n - zero);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
