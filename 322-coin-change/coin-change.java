class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length; // here val=wt
        int t=amount;
        int dp[][]= new int[n+1][t+1];
        // i-> value ,j->totalAmount

        //base case
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=1;j<t+1;j++){
            dp[0][j]=100000;
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<t+1;j++){
                if(coins[i-1]<=j){
                    dp[i][j]=Math.min(dp[i][j-coins[i-1]]+1,dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return (dp[n][t]>=100000)?-1:dp[n][t];
    }
}