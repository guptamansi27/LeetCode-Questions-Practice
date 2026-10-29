class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination)return true;

        //Make adjency matrix 
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0],b=edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] vis=new boolean[n];//false
        vis[source]=true;
        bfs(source,adj,vis,destination);
        /*if(vis[destination]){
            return true;
        }
        return false;*/
        return vis[destination];
    }
    private void bfs(int source,List<List<Integer>> adj,boolean[] vis,int destination){
        int n=adj.size();

        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        while(!q.isEmpty()){
            int front = q.remove();

            for(int ele:adj.get(front)){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele]=true;

                    //optional you can do ,also not
                    if(ele==destination) return;//stop checking other nodes if found
                }
            }
        }
    }
}