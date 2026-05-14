class Solution {
    public int singleNumber(int[] nums) {
       /* M1- Brute force ,t.c-O(n^2)
       int n=nums.length;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(nums[i]==nums[j])
                    count++;
            }
            if(count==1)
                return nums[i];
        }
        return -1;*/
        //Method 2 t.c-O(n)

        int ans=0;
        for(int num:nums){
             ans=ans^num;
        }
        return ans;
    }
}