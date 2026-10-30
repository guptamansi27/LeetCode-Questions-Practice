class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
    
        int ans1=profit(0,n-2,nums);
        int ans2=profit(1,n-1,nums);

        return Math.max(ans1,ans2);
    }
    public int profit(int s,int e,int[] nums){
        int n=e-s+1;

        int dp[]= new int[n];
        dp[0]=nums[s];

        if(n==1) return dp[0];

        dp[1]=Math.max(dp[0],nums[s+1]);

        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[s+i]);
        }
        return dp[n-1];
    }
}