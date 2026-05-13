class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] num = new int[2];
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j]==target){
                    num[0]=i;
                    num[1]=j;
                }

            }
        }
        return num;
    }
}