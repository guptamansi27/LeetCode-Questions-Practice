class Solution {
    public int[] numberOfPairs(int[] nums) {
        int ans[]= new int[2];
        int p=0,r=0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        for(Integer v : map.values()){
            if(v%2==0){
                p+=(v/2);
            }else{
                p+=(v/2);
                r+=1;
            }
        }
        ans[0]=p;
        ans[1]=r;

        return ans;

    }
}