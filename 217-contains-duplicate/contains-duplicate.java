class Solution {
    public boolean containsDuplicate(int[] nums) {
        /* Time exceed Error
        int n=nums.length;
        for(int i=0;i<n-1;i++)
        for(int j=i+1;j<n;j++)
            if(nums[i]==nums[j])
                return true;

    return false;*/

    Arrays.sort(nums);
    for(int i=0;i<nums.length-1;i++){
        if(nums[i]==nums[i+1])
            return true;
    }
    return false;
    }
}