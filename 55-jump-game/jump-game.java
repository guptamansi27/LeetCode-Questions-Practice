
class Solution {
    public boolean canJump(int[] nums) {

        int i = 0;       // Current index
        int idx = 0;     // Farthest reachable index

        // Continue while current index is reachable
        while (i <= idx) {

            // Update the maximum reachable position
            idx = Math.max(idx, i + nums[i]);

            // If the last index is reachable, return true
            if (idx >= nums.length - 1) {
                return true;
            }

            // Move to the next index to explore
            i++;
        }

        // If loop stops, the last index cannot be reached
        return false;
    }
}
