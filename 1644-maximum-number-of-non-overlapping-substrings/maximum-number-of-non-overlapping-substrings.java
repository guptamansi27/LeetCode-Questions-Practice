class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        // Initialize first occurrence as -1
        Arrays.fill(first, -1);

        // Find first and last occurrence of every character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            if (first[c] == -1) {
                first[c] = i;
            }

            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Find all valid substrings
        for (int c = 0; c < 26; c++) {

            if (first[c] == -1) {
                continue;
            }

            int left = first[c];
            int right = last[c];

            boolean valid = true;

            // Check all characters inside the interval
            for (int i = left; i <= right; i++) {

                int current = s.charAt(i) - 'a';

                // This character occurs before left
                if (first[current] < left) {
                    valid = false;
                    break;
                }

                // This character occurs after right
                right = Math.max(right, last[current]);
            }

            if (valid) {
                intervals.add(new int[]{left, right});
            }
        }

        // Sort intervals by ending position
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> result = new ArrayList<>();

        int previousEnd = -1;

        // Greedy: choose interval that ends earliest
        for (int[] interval : intervals) {

            int left = interval[0];
            int right = interval[1];

            if (left > previousEnd) {

                result.add(s.substring(left, right + 1));

                previousEnd = right;
            }
        }

        return result;
    }
}