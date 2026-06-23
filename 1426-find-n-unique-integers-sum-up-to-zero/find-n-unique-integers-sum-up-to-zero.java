class Solution {
    public int[] sumZero(int n) {
        int arr[] = new int[n];
        int ind=0;
        for(int i=1;i<=n/2;i++){
            arr[ind++]=i;
            arr[ind++]=-i;
        }
        if(n%2!=0)
            arr[ind]=0;
        return arr;
    }
}