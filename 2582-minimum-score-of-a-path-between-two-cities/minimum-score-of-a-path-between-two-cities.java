class Solution {
    public int minScore(int n, int[][] roads) {
        //adj list
        List<int[]>[] adj = new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] road:roads){
            int a=road[0];
            int b=road[1];
            int d=road[2];

            adj[a].add(new int[]{b,d});
            adj[b].add(new int[]{a,d});
        }

        boolean[] vis = new boolean[n+1];//false
        vis[1]=true;

        int minScore = bfs(1,adj,vis,n);
        return minScore;

    }
    private int bfs(int start,List<int[]>[] adj , boolean[] vis,int n){
        int min=Integer.MAX_VALUE;

        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()){
            int front =q.poll();

            for(int[] ele:adj[front]){
                int neigh=ele[0];
                int d=ele[1];

                min=Math.min(d,min);

                if(!vis[neigh]){
                    q.add(neigh);
                    vis[neigh]=true;
                }
            }
        }
        return min;
    }
}