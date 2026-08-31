class Solution {
    public void rotate(int[][] mat) {
        //Transpose
        int n=mat.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        //Reverse each row
        for(int i=0;i<n;i++){
            int l=0;
            int r=n-1;
            while(l<r){
                int temp = mat[i][l];
                mat[i][l]=mat[i][r];
                mat[i][r]=temp;

                l++;
                r--;
            }
        }

    }
}