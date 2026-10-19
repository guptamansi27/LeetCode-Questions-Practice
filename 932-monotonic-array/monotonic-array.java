class Solution {
    public boolean isMonotonic(int[] arr) {
        int n=arr.length;
        //if(n<=2)
           //return true;

        boolean inc=true;
        boolean dec=true;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1])
                inc=false;
            if(arr[i]<arr[i+1])
                dec=false;
        }
        return inc||dec;
    }
}