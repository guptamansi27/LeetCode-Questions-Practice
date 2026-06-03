class Solution {
    public double findMaxAverage(int[] nums, int k) {
        /*Brute force  tc-O(n*k)
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        //Iterate through all possible subarrays of length k
        for(int i=0;i<=n-k;i++){
            int sum = 0;
            //calculate sum of subarray starting at index i
            for(int j=i;j<i+k;j++){
                sum+=nums[j];
            }
            //update maxSum
            maxSum=Math.max(sum,maxSum);
        }
        return (double)maxSum/k; */
        
        /*OPtimal Approach */
          int sum = 0;

        // Sum of first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Slide the window
        for (int i = k; i < nums.length; i++) {

            sum -= nums[i - k];   // remove old element
            sum += nums[i];       // add new element

            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}