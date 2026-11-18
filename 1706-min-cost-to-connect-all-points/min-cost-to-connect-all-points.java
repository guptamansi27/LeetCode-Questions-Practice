
class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        boolean[] vis = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        pq.add(new int[]{0, 0});

        int sum = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {

            int[] curr = pq.poll();

            int node = curr[0];
            int wt = curr[1];

            if (vis[node]) {
                continue;
            }

            vis[node] = true;
            sum += wt;
            count++;

            // Visit all unvisited points
            for (int i = 0; i < n; i++) {

                if (!vis[i]) {

                    int dist = Math.abs(points[node][0] - points[i][0])
                             + Math.abs(points[node][1] - points[i][1]);

                    pq.add(new int[]{i, dist});
                }
            }
        }

        return sum;
    }
}
