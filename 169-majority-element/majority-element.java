//Method 1 - Brute Force
class Solution {
    public int majorityElement(int[] nums) {
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int n:nums){
        if(map.containsKey(n)){
            map.put(n,map.get(n)+1);
        }else{
            map.put(n,1);
        }
    }
    /*Way 1
    Integer maxKey=null;
    int maxVal=Integer.MIN_VALUE;
    for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        if(entry.getValue()>maxVal){
            maxVal=entry.getValue();
            maxKey=entry.getKey();
        }
    }
    return maxKey;*/
    //way 2
     Integer max = map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

    return max;
    }
}