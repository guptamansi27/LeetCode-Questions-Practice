class Solution {
    public int digitSum(int n){
        int s=0,rem=0;
        while(n>0){
            rem=n%10;
            s+=rem;
            n=n/10;
        }
        return s;
    }
    public int addDigits(int num) {
        while(String.valueOf(num).length()!=1){
            num=digitSum(num);
        }
        return num;
    }
}