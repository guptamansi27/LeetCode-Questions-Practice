class Solution {
    public int[] twoSum(int[] n, int target) {
        int num = n.length;
        int[] a = new int[2];

        for(int i = 0; i < num - 1; i++) {

            for(int j = i + 1; j < num; j++) {

                if(n[i] + n[j] == target) {
                    a[0] = i+1;
                    a[1] = j+1;
                    return a;
                }
            }
        }

        return a;
    }
}