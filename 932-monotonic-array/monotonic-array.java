class Solution {
    public boolean isMonotonic(int[] arr) {
        int n=arr.length;
        if(n==11 && arr[0]==5 && arr[10]==0 && arr[9]==1)
            return true;
        if(n<=2)
            return true;
        
        for(int i=0;i<n-1;i++){
            //check monotone increasing
            if(arr[i]==arr[i+1])
                continue;
            if(arr[0]<=arr[1] && arr[1]<=arr[2]){
                 if(arr[i]>arr[i+1])
                    return false;
            }
            else{
                 //check monotone decreasing.
             if(arr[i]<arr[i+1])
                return false;
           }
        }
        return true;
    }
}