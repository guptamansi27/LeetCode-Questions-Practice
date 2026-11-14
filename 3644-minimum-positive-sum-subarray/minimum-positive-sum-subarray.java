
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int n = nums.size();
        int min = Integer.MAX_VALUE;

        // Try every possible subarray length from l to r
        for (int k = l; k <= r; k++) {

            int sum = 0;

            // Calculate the sum of the first window of size k
            for (int j = 0; j < k; j++) {
                sum += nums.get(j);
            }

            // Check whether the first window has a positive sum
            if (sum > 0) {
                min = Math.min(min, sum);
            }

            // Slide the window through the remaining array
            for (int j = k; j < n; j++) {

                // Remove the element leaving the window
                sum -= nums.get(j - k);

                // Add the new element entering the window
                sum += nums.get(j);

                // Update minimum positive sum
                if (sum > 0) {
                    min = Math.min(min, sum);
                }
            }
        }

        // Return -1 if no positive subarray sum exists
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
