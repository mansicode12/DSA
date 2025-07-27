class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prev = new int[n];
        Arrays.fill(prev, Integer.MAX_VALUE);
        prev[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] curr = Arrays.copyOf(prev, n);

            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if (prev[from] != Integer.MAX_VALUE && prev[from] + price < curr[to]) {
                    curr[to] = prev[from] + price;
                }
            }

            prev = curr;
        }

        return prev[dst] == Integer.MAX_VALUE ? -1 : prev[dst];
    }
}
