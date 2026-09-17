class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;

        // minLen[i] = shortest valid subarray from 0 to i
        int[] minLen = new int[n];

        int l = 0;
        int sum = 0;

        int bestMin = n + 1;
        int result = n + 1;

        for (int r = 0; r < n; r++) {

            sum += arr[r];

            // Reduce window
            while (sum > target) {
                sum -= arr[l];
                l++;
            }

            // Found subarray [l ... r]
            if (sum == target) {

                int len = r - l + 1;

                // Previous non-overlapping subarray
                if (l > 0) {
                    result = Math.min(
                        result,
                        len + minLen[l - 1]
                    );
                }

                // Update shortest length
                bestMin = Math.min(bestMin, len);
            }

            // Store best answer till r
            minLen[r] = bestMin;
        }

        return result == n + 1 ? -1 : result;
    }
}