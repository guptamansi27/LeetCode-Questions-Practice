class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        String vowel="aeiou";
        int c=0;
        int max=0;
        for(int i=0;i<k;i++){
            if(vowel.indexOf(s.charAt(i))!=-1)
                c++;
        }
        max=c;
        for(int i=k;i<n;i++){
            if(vowel.indexOf(s.charAt(i-k))!=-1)
                c--;
            if(vowel.indexOf(s.charAt(i))!=-1)
                c++;

            max=Math.max(max,c);
        }
        return max;
    }
}