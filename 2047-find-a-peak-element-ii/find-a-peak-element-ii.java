class Solution {

    public int[] findPeakGrid(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = n - 1;

        // Perform Binary Search on columns
        while (low <= high) {

            // Find middle column
            int mid = low + (high - low) / 2;

            // Find the row having the maximum element in the middle column
            int maxRow = 0;
            for (int i = 1; i < m; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            // Get left and right neighbor values
            int left = (mid > 0) ? mat[maxRow][mid - 1] : -1;
            int right = (mid < n - 1) ? mat[maxRow][mid + 1] : -1;

            // If current element is greater than both neighbors, it is a peak
            if (mat[maxRow][mid] > left && mat[maxRow][mid] > right) {
                return new int[] { maxRow, mid };
            }

            // Move to the left half
            else if (left > mat[maxRow][mid]) {
                high = mid - 1;
            }

            // Move to the right half
            else {
                low = mid + 1;
            }
        }

        // A peak always exists, so this line is never reached
        return new int[] { -1, -1 };
    }
}