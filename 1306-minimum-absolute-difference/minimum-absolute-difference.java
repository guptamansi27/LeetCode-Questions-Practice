class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
         Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();

        int min = Integer.MAX_VALUE;

        // Find minimum difference
        for(int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }

        // Store pairs
        for(int i = 0; i < arr.length - 1; i++) {

            if(arr[i + 1] - arr[i] == min) {

                List<Integer> temp = new ArrayList<>();

                temp.add(arr[i]);
                temp.add(arr[i + 1]);

                ans.add(temp);
            }
        }

        return ans;
    }
}