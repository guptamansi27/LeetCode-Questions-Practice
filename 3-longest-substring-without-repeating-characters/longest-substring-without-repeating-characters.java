class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n = s.length();

       HashSet<Character> seen = new HashSet<>();
       int maxLength = 0;
       int left = 0;

       for(int right=0;right<n;right++){
            while(seen.contains(s.charAt(right))){
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            //maxLength = Math.max(maxLength,right-left+1);
            maxLength = Math.max(maxLength,seen.size());//current window size for each iteration equal to set size
       }
       return maxLength;
    }
}