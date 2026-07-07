class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            // Find the middle index
            int mid = low + (high - low) / 2;

            // If we are on the increasing slope,
            // the peak lies on the right side.
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }
            // If we are on the decreasing slope,
            // mid can be the peak, so keep it.
            else {
                high = mid;
            }
        }

        // low == high, pointing to the peak index
        return low;
    }
}