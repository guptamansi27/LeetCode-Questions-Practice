class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        int j=0,k=n-1;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                arr[j]=nums[i];
                j++;
            }
            else{
                arr[k]=nums[i];
                k--;
            }
        }
        return arr;
    }
}