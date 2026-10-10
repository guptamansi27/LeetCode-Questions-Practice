class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        int max = 0;
        int[] diff = new int[n];

        long total = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            total += diff[i];
        }

        if (total <= k) return 0;

        int low = 0, high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long need = 0;

            for (int d : diff) {
                if (d > mid) need += d - mid;
            }

            if (need <= k) high = mid;
            else low = mid + 1;
        }

        int limit = low;
        long remaining = k;

        for (int i = 0; i < n; i++) {
            if (diff[i] > limit) {
                remaining -= diff[i] - limit;
                diff[i] = limit;
            }
        }

        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] == limit && limit > 0) {
                diff[i]--;
                remaining--;
            }
        }

        long ans = 0;

        for (int d : diff) {
            ans += (long) d * d;
        }

        return ans;
    }
}