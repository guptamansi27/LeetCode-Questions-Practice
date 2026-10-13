class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        long s=0;
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=0;i--){
            if(i>=(nums.length/2))
                s+=nums[i];
            else
                s-=nums[i];
        }
        return s;
    }
}