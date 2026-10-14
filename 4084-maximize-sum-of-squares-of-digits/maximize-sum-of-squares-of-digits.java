class Solution {
    public String maxSumOfSquares(int num, int sum) {
       if(sum>num*9)return "";//as with num digits ,max sum possible is 9*num

        StringBuilder s=new StringBuilder();
        int nines=sum/9;
        int rem=sum%9;

        for(int i=0;i<nines;i++)
            s.append('9');
        
        if(rem>0){
            s.append(String.valueOf(rem));
        }

        int c=num-s.length();
        for(int i=0;i<c;i++){
            s.append('0');
        }
        return s.toString();
    }
}