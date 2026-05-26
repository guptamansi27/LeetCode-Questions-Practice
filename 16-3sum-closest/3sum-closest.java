class Solution {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int n = nums.length;

        int closest = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < n - 2; i++) {

            int l = i + 1;
            int r = n - 1;

            while(l < r) {

                int sum = nums[i] + nums[l] + nums[r];

                // update closest sum
                if(Math.abs(sum - target) <
                   Math.abs(closest - target)) {

                    closest = sum;
                }

                // exact match
                if(sum == target) {
                    return sum;
                }

                // need bigger sum
                else if(sum < target) {
                    l++;
                }

                // need smaller sum
                else {
                    r--;
                }
            }
        }

        return closest;
    }
}