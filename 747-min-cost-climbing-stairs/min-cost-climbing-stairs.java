class Solution {
    public int helper(int[] cost, int i, Integer[] cache) {
        if (i == 0 || i == 1) {
            return cost[i];
        }
        if (cache[i] != null) {
            return cache[i];
        }

        cache[i] = cost[i] + Math.min(helper(cost, i - 1, cache), helper(cost, i - 2, cache));
        return cache[i];
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        Integer[] cache = new Integer[n];
        return Math.min(helper(cost, n - 1, cache), helper(cost, n - 2, cache));
    }
}
