class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int max = 0;

        // Increasing subarray
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                if (!list.contains(i))
                    list.add(i);
                list.add(i + 1);
            } else {
                list.clear();
            }
            max = Math.max(list.size(), max);
        }

        list.clear();

        // Decreasing subarray
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (!list.contains(i))
                    list.add(i);
                list.add(i + 1);
            } else {
                list.clear();
            }
            max = Math.max(list.size(), max);
        }

        return (max == 0 && n != 0) ? 1 : max;
    }
}