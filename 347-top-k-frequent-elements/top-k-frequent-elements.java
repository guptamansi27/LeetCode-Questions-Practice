class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        TreeMap<Integer,List<Integer>> map2 = new TreeMap<>(Comparator.reverseOrder());
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            map2.computeIfAbsent(e.getValue(),m->(new ArrayList<>())).add(e.getKey());
        }
        int ans[] = new int[k];
        int i =0;
        for(List<Integer> l:map2.values()){
            for(int n:l){
                if(i == k)
                    break;
                ans[i++] = n;
            }
            if(i==k)
                break;
        }
        return ans;
    }
}