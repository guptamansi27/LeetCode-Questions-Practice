class Solution {
    public int[] twoSum(int[] nums, int target) {
    /*Method 1 - brute force
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
        return num;*/
        //Method 2- optimal
       HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            int need = target - nums[i];

            if(map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}