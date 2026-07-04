public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int low = 1;      // Search starts from version 1
        int high = n;     // Search ends at version n

        while (low < high) {

            // Safer way to calculate mid (avoids overflow)
            int mid = low + (high - low) / 2;

            /*int mid = (high + low) / 2; Using mid = (low + high) / 2 can cause integer overflow when low + high exceeds Java’s int limit, giving a wrong mid.
            Wrong mid breaks binary search (pointers may not move correctly), causing infinite loop amd time exceed error*/

            // If mid is bad, first bad version can be mid or left side
            if (isBadVersion(mid)) {
                high = mid;     // Keep mid in search space
            }

            // If mid is good, first bad must be on right side
            else {
                low = mid + 1;  // Remove mid
            }
        }

        // When low == high, we found first bad version
        return low;
    }
}