class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Map each reachable XOR value to whether it is possible
        Set<Integer>[][] dp = new HashSet[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashSet<>();
            }
        }

        dp[0][0].add(grid[0][0]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                if (i > 0) {
                    for (int x : dp[i - 1][j]) {
                        dp[i][j].add(x ^ grid[i][j]);
                    }
                }

                if (j > 0) {
                    for (int x : dp[i][j - 1]) {
                        dp[i][j].add(x ^ grid[i][j]);
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int x : dp[m - 1][n - 1]) {
            ans = Math.min(ans, x);
        }

        return ans;
    /*Method 2: Time exceed Error
    int ans=Integer.MAX_VALUE;
    public int minCost(int[][] grid) {
        ans=Integer.MAX_VALUE;
        dfs(grid,0,0,0);
        return ans;
    }
    void dfs(int[][] grid,int r,int c,int xor){
        int m=grid.length;
        int n=grid[0].length;

         // XOR the current cell
         xor^=grid[r][c];

          // Reached destination
        if(r==m-1 && c==n-1){
            ans=Math.min(ans,xor);
            return;
        }
        //move right
        if(c+1<n){
            dfs(grid,r,c+1,xor);
        }
        //move down
        if(r+1<m){
            dfs(grid,r+1,c,xor);
        }*/
    }
}