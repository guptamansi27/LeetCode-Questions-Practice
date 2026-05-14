class Solution {
    public int[][] transpose(int[][] matrix) {
        int col = matrix.length,row= matrix[0].length;
        int[][] t = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                t[i][j]=matrix[j][i];
            }
        }
        return t;
    }
}