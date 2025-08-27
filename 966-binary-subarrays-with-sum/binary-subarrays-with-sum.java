class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);  // base case

        int prefixSum = 0;
        int result = 0;

        for (int num : nums) {
            prefixSum += num;

            // Check if there is a prefix sum that when subtracted gives us the goal
            result += prefixSumCount.getOrDefault(prefixSum - goal, 0);

            // Store the current prefix sum count
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return result;
    
    }
}