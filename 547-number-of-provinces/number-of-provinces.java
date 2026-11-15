class Solution {
    public int findCircleNum(int[][] adj) {
        int n=adj.length;
        boolean vis[] = new boolean[n];

        int c=0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(adj,vis,i);
                c++;
            }
        }
        return c;
    }
    private void bfs(int [][] adj,boolean[] vis,int i){
        int n= adj.length;
        vis[i]=true;

        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int front = q.poll();

            for(int j=0;j<n;j++){
                if(adj[front][j]==1 && vis[j]==false){
                    q.add(j);
                    vis[j]=true;
                }
            }
        }
    }
}