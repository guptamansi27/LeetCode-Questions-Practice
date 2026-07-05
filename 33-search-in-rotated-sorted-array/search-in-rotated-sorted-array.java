class Solution {
    public int search(int[] nums, int target) {

        // low points to starting index
        int low = 0;

        // high points to last index
        int high = nums.length - 1;

        // Binary search runs until search space is valid
        while (low <= high) {

            // Find middle index
            // Using this formula avoids overflow compared to (low + high)/2
            int mid = low + (high - low) / 2;

            // If middle element is target, return its index
            if (nums[mid] == target)
                return mid;

            // Check whether LEFT half is sorted
            // If nums[low] <= nums[mid], then elements from low to mid
            // are in increasing order (sorted)
            if (nums[low] <= nums[mid]) {

                // Now check whether target lies inside left sorted half
                // target >= nums[low]  → target is not smaller than left boundary
                // target < nums[mid]   → target is before mid
                if (target >= nums[low] && target < nums[mid]) {

                    // Since target lies in left half,
                    // discard right half
                    high = mid - 1;

                } else {

                    // Target is not in left sorted half,
                    // so search in right half
                    low = mid + 1;
                }
            }

            // Otherwise RIGHT half must be sorted
            else {

                // Check whether target lies inside right sorted half
                // target > nums[mid]   → target lies after mid
                // target <= nums[high] → target within right boundary
                if (target > nums[mid] && target <= nums[high]) {

                    // Target lies in right half,
                    // discard left half
                    low = mid + 1;

                } else {

                    // Target is not in right sorted half,
                    // so search in left half
                    high = mid - 1;
                }
            }
        }

        // If loop ends, target is not present
        return -1;
    }
}