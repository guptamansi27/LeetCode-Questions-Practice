import java.util.*;

class Solution {
    public int sortPermutation(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);

        // If already sorted, return 0
        if (Arrays.equals(nums, copy)) {
            return 0;
        }

        int k = -1;

        // Find all misplaced elements and calculate their AND
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copy[i]) {
                if (k == -1) {
                    k = nums[i];
                } else {
                    k &= nums[i];
                }
            }
        }

        return k;
    }
}