class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
       /* int j=0;
        int k=1;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                ans[j]=nums[i];
                j+=2;
            }
            else{
                ans[k]=nums[i];
                k+=2;;
            }
        }
        return ans;*/
        int e=0,o=1;
        int i=0;
        while(e<n && o<n){
            if(nums[e]%2==0){
                e+=2;
            }else if(nums[o]%2!=0){
                o+=2;
            }else{
                int temp=nums[o];
                nums[o]=nums[e];
                nums[e]=temp;
                o+=2;
                e+=2;
            }
        }
        return nums;
    }
}