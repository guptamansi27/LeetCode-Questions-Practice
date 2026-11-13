
import java.util.*;

class Solution {

    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        long ans = 0;
        long cost = 0;

        // Store {value, count} in a monotonic deque
        Deque<int[]> dq = new ArrayDeque<>();

        int j = n - 1;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            int num = nums[i];
            int count = 1;

            // Merge smaller groups into current number
            while (!dq.isEmpty() && dq.peekLast()[0] < num) {

                int[] last = dq.pollLast();

                int nextNum = last[0];
                int nextCount = last[1];

                count += nextCount;

                // Cost of increasing smaller elements
                cost += (long) (num - nextNum) * nextCount;
            }

            dq.offerLast(new int[]{num, count});

            // Shrink window if operations exceed k
            while (cost > k) {

                int[] first = dq.pollFirst();

                int rightmostNum = first[0];
                int rightmostCount = first[1];

                cost -= (long) (rightmostNum - nums[j]);

                j--;

                // Preserve remaining elements in this group
                if (rightmostCount > 1) {
                    dq.offerFirst(
                        new int[]{rightmostNum, rightmostCount - 1}
                    );
                }
            }

            // Count valid subarrays ending within [i, j]
            ans += j - i + 1;
        }

        return ans;
    }
}
