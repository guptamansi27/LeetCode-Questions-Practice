class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        
        int min=Integer.MAX_VALUE;

        for(int i=l;i<=r;i++){
            System.out.println("Iteration: "+(i-l));
            int sum=0;
            for(int j=0;j<i;j++){
                System.out.println("Hi");
                sum+=nums.get(j);
            }
            if(sum>0)
                min=Math.min(sum,min);
            
            System.out.println(sum+" : "+min);
            for(int j=i;j<n;j++){
                sum-=nums.get(j-i);
                sum+=nums.get(j);

                if(sum>0)
                    min=Math.min(sum,min);
                System.out.println(sum+" : "+min);

            }
        }
        return (min==Integer.MAX_VALUE)?-1:min;
    }
}