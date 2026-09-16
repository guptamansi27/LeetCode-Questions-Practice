class Solution {
    public int longestConsecutive(int[] nums) {
       HashSet<Integer> set = new HashSet<>();
       for(int x:nums){
            set.add(x);
       }
       int maxLen=0;
       for(int x :set){
        //x is starting point
            if(!set.contains(x-1)){
                int count=1;
                while(set.contains(x+count))
                    count++;
                maxLen=Math.max(count,maxLen);
            }
       }
       return maxLen;
    }
}