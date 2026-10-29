class Solution {
      class Pair{
        int row,col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int c=0;
        boolean[][] vis = new boolean[m][n];//false

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                     bfs(i,j,grid,vis);
                    c++;
                }
            }
        }
        return c;
    }
  
    private void bfs(int row,int col,char[][] grid,boolean[][] vis){
        int m=grid.length,n=grid[0].length;
        Queue<Pair> q= new LinkedList<>();

        q.add(new Pair(row,col));

        while(!q.isEmpty()){
            Pair front= q.remove();

            row=front.row;
            col=front.col;

            //top-> row-1,col
            if(row>0){
                if(vis[row-1][col]==false && grid[row-1][col]=='1'){
                    q.add(new Pair(row-1,col));
                    vis[row-1][col]=true;
                }
            }
            //bottom -> row+1,col
            if(row+1<m){
                if(vis[row+1][col]==false && grid[row+1][col]=='1'){
                    q.add(new Pair(row+1,col));
                    vis[row+1][col]=true;
                }
            }
            //right->row,col+1
            if(col+1<n){
                if(vis[row][col+1]==false && grid[row][col+1]=='1'){
                    q.add(new Pair(row,col+1));
                    vis[row][col+1]=true;
                }
            }
            //left -> row,col-1
            if(col>0){
                if(vis[row][col-1]==false && grid[row][col-1]=='1'){
                    q.add(new Pair(row,col-1));
                    vis[row][col-1]=true;
                }
            }
        }
    }
}