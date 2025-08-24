import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    static class Edge {
        int to, wt;
        Edge(int to, int wt) { this.to = to; this.wt = wt; }
    }
    static class Node {
        long dist;
        int u;
        Node(long dist, int u) { this.dist = dist; this.u = u; }
    }

    public int countPaths(int n, int[][] roads) {
        // Build graph
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] r : roads) {
            adj.get(r[0]).add(new Edge(r[1], r[2]));
            adj.get(r[1]).add(new Edge(r[0], r[2]));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        long[] ways = new long[n];

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.dist));

        dist[0] = 0L;
        ways[0] = 1L;
        pq.add(new Node(0L, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            long d = cur.dist;
            int u = cur.u;
            if (d > dist[u]) continue; // stale entry

            for (Edge e : adj.get(u)) {
                int v = e.to;
                long nd = d + e.wt; // all long now
                if (nd < dist[v]) {
                    dist[v] = nd;
                    ways[v] = ways[u];
                    pq.add(new Node(nd, v));
                } else if (nd == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return (int) (ways[n - 1] % MOD);
    }
}
