class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n=adj.size();
        boolean vis[] = new boolean[n];//false

        vis[0]=true;
        bfs(0,vis,adj);

        for(boolean ele : vis){
            if(ele==false)
                return false;
        }
        return true;
    }
    private void bfs(int start, boolean[] vis, List<List<Integer>> adj){
        int n=adj.size();
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int front= q.remove();

            for(int ele : adj.get(front)){
                if(!vis[ele]){
                    vis[ele]=true;
                    q.add(ele);
                }
            }
        }
    }
}