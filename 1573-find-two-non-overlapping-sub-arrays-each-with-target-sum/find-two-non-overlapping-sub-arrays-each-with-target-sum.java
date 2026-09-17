class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int[] dp = new int[arr.length];

        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int result = -1;

        for (int right = 0; right < arr.length; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {

                int len = right - left + 1;

                if (left > 0 && dp[left - 1] > 0) {
                    result = result == -1
                           ? len + dp[left - 1]
                           : Math.min(result, len + dp[left - 1]);
                }

                min = Math.min(min, len);
            }

            dp[right] = min == Integer.MAX_VALUE ? 0 : min;
        }

        return result;
    }
}