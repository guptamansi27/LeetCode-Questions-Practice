class Solution {
    public double findMaxAverage(int[] nums, int k) {
        /*Brute force */
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
        return (double)maxSum/k;
    }
}