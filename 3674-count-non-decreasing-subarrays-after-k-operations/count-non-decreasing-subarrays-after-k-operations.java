/* method 1 - 719/731 passed tessed case due to tle
class Solution {
    public boolean nonDecWithK(int i,int j,int k,int[] nums){
        int diff=0;
        int max=nums[i];
        for(int t=i;t<=j;t++){
            max=Math.max(max,nums[t]);
            if(max>nums[t]){
                diff+=(max-nums[t]);
            }
            if(diff>k)
                return false;
        }
        return true;
    }
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int l=0,r=0;
        long nD=0;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                boolean nonDec= nonDecWithK(i,j,k,nums);
                if(nonDec){
                    nD++;
                }
            }
        }
        return nD+n;
    }
}*/

import java.util.*;

class Solution {

    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        long nD = 0;
        long diff = 0;

        int j = n - 1;

        Deque<int[]> dq = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {

            int max = nums[i];
            int count = 1;

            // Merge smaller elements
            while (!dq.isEmpty() && dq.peekLast()[0] < max) {

                int[] last = dq.pollLast();

                diff += (long)(max - last[0]) * last[1];

                count += last[1];
            }

            dq.offerLast(new int[]{max, count});

            // Shrink window if operations exceed k
            while (diff > k) {

                int[] first = dq.pollFirst();

                diff -= (long)(first[0] - nums[j]);

                j--;

                if (first[1] > 1) {
                    dq.offerFirst(
                        new int[]{first[0], first[1] - 1}
                    );
                }
            }

            // Count valid subarrays
            nD += j - i + 1;
        }

        return nD;
    }
}
