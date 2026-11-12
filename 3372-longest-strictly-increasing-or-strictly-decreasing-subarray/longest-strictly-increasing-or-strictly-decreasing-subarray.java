class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        /*Method 1
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

        return (max == 0 && n != 0) ? 1 : max;*/
        /*Approach	       TC	       SC
Your ArrayList approach	 (O(n^2)	   O(n)
Two-counter approach     (O(n)	       (O(1)*/

//Method 2
    int n=nums.length;
    int inc=1;
    int dec=1;
    int max=1;

    for(int i=1;i<n;i++){
        // Strictly increasing
        if(nums[i]>nums[i-1]){
            inc++;
        }else{
            inc=1;
        }
        // Strictly decreasing
        if(nums[i]<nums[i-1]){
            dec++;
        }else{
            dec=1;
        }

        max=Math.max(max,Math.max(inc,dec));
    }
    return max;
    }
}